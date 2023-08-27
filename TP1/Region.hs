module Region ( Region, newR, foundR, linkR, tunelR, pathR, linksForR, connectedR, linkedR, delayR, availableCapacityForR, usedCapacityForR )
   where
      
import Tunel

data Region = Reg [City] [Link] [Tunel]
newR :: Region
newR = Reg

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg cities links tunels) newCity = Reg (newCity : cities) links tunels

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cities links tunels) city1 city2 quality | citiesInR (Reg cities links tunels) city1 city2 && not (linkedR (Reg cities links tunels) city1 city2) = Reg cities (newL city1 city2 quality : links) tunels
                                                     | otherwise = error "Alguna de las ciudades no pertenece a la región o el link ya existe"

tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR region cities = --terminar

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg cities links tunels) city1 city2 = citiesInR region city1 city2 && headsT city1 city2 link

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg cities links tunels) city1 city2 = citiesinR (Reg cities links tunels) city1 city2 && linksL city1 city2 link

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR (Reg _ _ tunels) city1 city2 =
   let Just tunel = findTunel tunels city1 city2 in delayT tunel

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades

citiesInR :: Region -> City -> City -> Bool
citiesInR (Reg cities _ _) city1 city2 = city1 `elem` cities && city2 `elem` cities

findTunel :: [Tunel] -> City -> City -> Maybe Tunel
findTunel [] _ _ = Nothing
findTunel (tunel: otrostuneles) city1 city2 
 | connectsT city1 city2 tunel = Just tunel
 | otherwise = findTunel otrostuneles city1 city2