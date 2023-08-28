module Region ( Region, newR, foundR, linkR, tunelR, connectedR, linkedR, delayR, availableCapacityForR )
   where

import City
import Link
import Tunel
import Quality
import Data.Maybe

data Region = Reg [City] [Link] [Tunel]
newR :: Region
newR = Reg [] [] []

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg cities links tunels) newCity = Reg (newCity : cities) links tunels

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cities links tunels) city1 city2 quality | citiesInR (Reg cities links tunels) city1 city2 && not (linkedR (Reg cities links tunels) city1 city2) = Reg cities (newL city1 city2 quality : links) tunels
                                                    | otherwise = error "Alguna de las ciudades no pertenece a la región o el link ya existe"

tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR region@(Reg cities links tunels) cityList | areLinked region links (pairCitiesFromList cityList) = Reg cities links (tunels ++ [newTunel])
                                                 | otherwise = error "No se pueden crear los túneles"
    where
        newTunel = newT (generateLinksFromPairs links (pairCitiesFromList cityList))

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR region@(Reg cities links tunels) city1 city2 = citiesInR region city1 city2 && foldr ((||).connectsT city1 city2) False tunels

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg cities links tunels) city1 city2 =
    case findLink links city1 city2 of
        Just link -> citiesInR (Reg cities links tunels) city1 city2 && linksL city1 city2 link
        Nothing -> False

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR (Reg _ _ tunels) city1 city2 =
   let Just tunel = findTunel tunels city1 city2 in delayT tunel

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR (Reg cities links tunels) city1 city2 =
    case findLink links city1 city2 of
        Just link -> capacityL link - tunelsInLink link tunels
        Nothing -> 0

citiesInR :: Region -> City -> City -> Bool
citiesInR (Reg cities _ _) city1 city2 = city1 `elem` cities && city2 `elem` cities

findTunel :: [Tunel] -> City -> City -> Maybe Tunel
findTunel [] _ _ = Nothing
findTunel (tunel: otrostuneles) city1 city2
 | connectsT city1 city2 tunel = Just tunel
 | otherwise = findTunel otrostuneles city1 city2

findLink :: [Link] -> City -> City -> Maybe Link
findLink [] _ _ = Nothing
findLink (link: otroslinks) city1 city2
 | linksL city1 city2 link = Just link
 | otherwise = findLink otroslinks city1 city2

tunelsInLink :: Link -> [Tunel] -> Int
tunelsInLink link tunels = length (filter (usesT link) tunels)

pairCitiesFromList :: [City] -> [[City]]
pairCitiesFromList cities = map (take 2) (tail [cities])

areLinked :: Region -> [Link] -> [[City]] -> Bool
areLinked region links = all (\pair -> areLinkedAndAvailable region pair links)

areLinkedAndAvailable :: Region -> [City] -> [Link] -> Bool
areLinkedAndAvailable region [city1, city2] = all (\link -> linksL city1 city2 link && availableCapacityForR region city1 city2 > 0)

generateLinksFromPairs :: [Link] -> [[City]] -> [Link]
generateLinksFromPairs links = mapMaybe (\[city1, city2] -> findLink links city1 city2)