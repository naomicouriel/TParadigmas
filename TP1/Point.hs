module Point ( Point, newP, difP)
   where

data Point = Poi Int Int deriving (Eq, Show)

newP :: Int -> Int -> Point
newP x y = Poi x y

difP :: Point -> Point -> Float  -- distancia absoluta
difP (Poi x y) (Poi z w) = norma (Poi (x-z) (y-w))

norma :: Point -> Float
norma (Poi x y) = sqrt (fromIntegral (x^2 + y^2))
