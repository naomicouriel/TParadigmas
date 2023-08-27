module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where

import Link
import City

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT = Tun

connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
connectsT city1 city2 (Tun links) = any (\link -> linksL city1 city2 link) links

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT link1 (Tun links) = elem link1 links

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun links) = sum (map delayL links)

headsT :: City -> City -> Link -> Bool
headsT city1 city2 link | isFirst city1 link && isLast city2 link = True
                        | isFirst city2 link && isLast city1 link = True
                        | otherwise = False

isFirst :: City -> Tunel -> Bool
isFirst _ (Tun []) = False
isFirst city (Tun (link:_)) = headsT city (city1Link link)

isLast :: City -> Tunel -> Bool
isLast _ (Tun []) = False
isLast city (Tun links) = headsT city (city2Link (last links))

city1Link :: Link -> City
city1Link (Lin city1 _ _) = city1

city2Link :: Link -> City
city2Link (Lin _ city2 _) = city2