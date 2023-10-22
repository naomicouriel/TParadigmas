package NemoPackage;

import java.util.Arrays;
import java.util.List;

public abstract class Direccion{
	
	String direction;
	
	public static List<Direccion> headingsList = Arrays.asList(new South(), new North(), new East(), new West());
 
	protected abstract Direccion executeLeftCommand();
	protected abstract Direccion executeRightCommand();
    protected abstract Posicion avanzar(Posicion posicion);
	protected abstract String getDireccion();
    
}
