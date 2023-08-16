module City ( City, newC, nameC, distanceC )
   where

import Main

data City = Cit String Point deriving (Eq, Show)

newC :: String -> Point -> City
newC nombre (Poi x y) = Cit nombre (Poi x y)

nameC :: City -> String
nameC Cit nombre (Poi x y) = nombre

distanceC :: City -> City -> Float
distanceC (Cit nombre (Poi x y)) (Cit nombre (Poi z w)) = difP (Poi x y) (Poi z w)