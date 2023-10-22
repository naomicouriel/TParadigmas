package NemoPackage;

public class Nemo {
	
    public static String CannotReleaseCapsuleInDeeperLevels = "No se puede liberar la cápsula en este nivel. Destruyendo submarino en 3... 2... 1...";

    private OficialDeProfundidad profundidad = new Superficie();
    private Direccion direccion;
    private Posicion posicion;
    static boolean chocolateCapsuleIsReleased;
    
    public Nemo(Posicion posicion, Direccion direccion) {
        this.direccion = direccion;
        this.posicion = posicion;
        chocolateCapsuleIsReleased = false;
    }

    public int getPositionX() {
        return posicion.getX();
    }
  
    public int getPositionY() {
        return posicion.getY();
    }

    public int getDepth() {
        return profundidad.getNivel();
    }

    public String getDirection() {
        return direccion.getDireccion();
    }
    
    public void move(String comandos) {
    	comandos.chars()
        .forEach(command -> move((char) command));
    }
    
    public void move(char c) {
    	Comando.commandFor(c).execute(this);
    }

	public void descend() {
		profundidad = profundidad.executeDownCommand();
	}

	public void ascend() {
		profundidad = profundidad.executeUpCommand();
	}

	public void rotateToLeft() {
		direccion = direccion.executeLeftCommand();	
	}

	public void rotateToRight() {
		direccion = direccion.executeRightCommand();		
	}

	public void moveForward() {
		posicion = direccion.avanzar(posicion);		
	}

	public void releaseCapsule() {
		profundidad.releaseCapsule();	
	}
    
}

