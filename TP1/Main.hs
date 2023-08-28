import Point
import City
import Link
import Quality
import Region
import Tunel

conexion1 = newQ "calidad" 2 3.5
conexion2 = newQ "calidad" 3 4.5

cityPilar = newC "Pilar" (newP 1 2)
cityCampana = newC "Campana" (newP 3 5)
cityCaba = newC "CABA" (newP 0 0)
cityZarate = newC "Zarate" (newP 5 0)
cityMerlo = newC "Merlo" (newP 0 5)
cityTigre = newC "Tigre" (newP 5 5)
cityLaPlata = newC "La Plata" (newP 2 10)
cityVictoria = newC "Victoria" (newP 4 3)

enlaceCabaPilar = newL cityCaba cityPilar conexion1
enlacePilarCampana = newL cityPilar cityCampana conexion1
enlaceCampanaZarate = newL cityCampana cityZarate conexion2

tunelCabaCampana = newT [enlaceCabaPilar, enlacePilarCampana]
tunelPilarZarate = newT [enlacePilarCampana, enlaceCampanaZarate]

region1 = newR
region2 = foundR region1 cityMerlo
region3 = foundR region2 cityTigre
region4 = foundR region3 cityLaPlata
region5 = foundR region4 cityVictoria
region6 = linkR region5 cityMerlo cityTigre conexion2
region7 = linkR region6 cityTigre cityLaPlata conexion2
region8 = linkR region7 cityLaPlata cityVictoria conexion1
region9 = tunelR region8 [cityMerlo, cityTigre, cityLaPlata, cityVictoria]

t = [connectsL cityCaba enlaceCabaPilar,
    linksL cityPilar cityCampana enlacePilarCampana,
    connectsT cityCaba cityCampana tunelCabaCampana,
    usesT enlaceCampanaZarate tunelPilarZarate,
    connectedR region9 cityMerlo cityVictoria,
    linkedR region9 cityLaPlata cityVictoria]