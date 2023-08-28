{-# OPTIONS_GHC -Wno-unrecognised-pragmas #-}
{-# HLINT ignore "Use newtype instead of data" #-}
{-# HLINT ignore "Avoid lambda" #-}
{-# HLINT ignore "Use list literal pattern" #-}
module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where

import Link
import City

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT = Tun

connectsT :: City -> City -> Tunel -> Bool -- indica si este tunel conceta estas dos ciudades distintas
connectsT city1 city2 (Tun links) | isEnd city1 links && isEnd city2 links = True
                                  | otherwise = False

usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
usesT link1 (Tun links) = link1 `elem` links

delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel
delayT (Tun links) = sum (map delayL links)

isEnd :: City -> [Link] -> Bool
isEnd _ [] = False
isEnd c (a:[]) = connectsL c a
isEnd c (a:b:lista) = (connectsL c b && not (connectsL c a)) || connectsL c a && not (connectsL c b)