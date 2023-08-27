import Point
import City
import Link
import Quality
--import Region
import Tunel

conexion1 = newQ "velocidad" 2 3.5

cityPilar = newC "Pilar" (newP 1 2)

enlaceCabaPilar = newL (newC "CABA" (newP 0 0)) cityPilar conexion1
enlacePilarCampana = newL cityPilar (newC "Campana" (newP 3 5)) conexion1

tunelCabaPilarCampana = newT [enlaceCabaPilar, enlacePilarCampana]