package linea;

import java.util.Arrays;
import java.util.List;

public abstract class Estrategia {
	public static List<Estrategia> estrategiasList = Arrays.asList(new EstrategiaA(), new EstrategiaB(), new EstrategiaC());
	
	public abstract boolean checkWin(Linea linea);
	public abstract char getKey();
	
	public Estrategia estrategiaWith(char estrategiaIngresada){
    	return estrategiasList
                .stream()
                .filter(estrategia -> isKeyMatch(estrategia, estrategiaIngresada))
                .findFirst()
                .orElseThrow();
    			
    }

    public static boolean isKeyMatch(Estrategia estrategia, char estrategiaIngresada) {
        return estrategia.getKey() == estrategiaIngresada;
    }
    	    
 }