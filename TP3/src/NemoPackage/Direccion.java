package NemoPackage;

import java.util.Arrays;
import java.util.List;

public abstract class Direccion{
	
	String direction;

	protected abstract Direccion executeLeftCommand();
	protected abstract Direccion executeRightCommand();
    protected abstract Posicion avanzar(Posicion posicion);
    
    public Direccion(String direction) {
    	this.direction = direction;
    }

	public interface Direction {
	    String getDireccion();
	}
    
    public void main(String[] args) {
        List<Direction> headingsList = Arrays.asList(new South(direction), new North(direction), new East(direction), new West(direction));
    }
    
    class South extends Direccion implements Direction{
    	public South(String direction) {
			super(direction);
			// TODO Auto-generated constructor stub
		}

		public String direccion = "South";
    	
    	public String getDireccion() {
    		return direccion;
    	}
    	
    	public Direccion executeLeftCommand() {
    		return new East("East");
    	}
    	
    	public Direccion executeRightCommand() {
    		return new West("West");
    	}
    	
    	public Posicion avanzar(Posicion posicion) {
    		Posicion newPosicion = Posicion.addCoordinates(posicion, 1, 0);
    		return newPosicion;
    	}
    	
    }
    
    class North extends Direccion implements Direction{
    	public North(String direction) {
			super(direction);
			// TODO Auto-generated constructor stub
		}

		public String direccion = "North";
    	
    	public String getDireccion() {
    		return direccion;
    	}
    	
    	public Direccion executeLeftCommand() {
    		return new West("West");
    	}
    	
    	public Direccion executeRightCommand() {
    		return new East("East");
    	}

    	public Posicion avanzar(Posicion posicion) {
    		Posicion newPosicion = Posicion.addCoordinates(posicion, 1, 0);
    		return newPosicion;
    	}
    }
    
    class East extends Direccion implements Direction{
    	public East(String direction) {
			super(direction);
			// TODO Auto-generated constructor stub
		}

		public String direccion = "East";
    	
    	public String getDireccion() {
    		return direccion;
    	}
    	
    	public Direccion executeLeftCommand() {
    		return new North("North");
    	}
    	
    	public Direccion executeRightCommand() {
    		return new South("South");
    	}

    	public Posicion avanzar(Posicion posicion) {
    		Posicion newPosicion = Posicion.addCoordinates(posicion, 0, 1);
    		return newPosicion;
    	}
    }
    
    class West extends Direccion implements Direction{
    	public West(String direction) {
			super(direction);
			// TODO Auto-generated constructor stub
		}

		public String direccion = "West";
    	
    	public String getDireccion() {
    		return direccion;
    	}
    	
    	public Direccion executeLeftCommand() {
    		return new South("South");
    	}
    	
    	public Direccion executeRightCommand() {
    		return new North("North");
    	}

    	public Posicion avanzar(Posicion posicion) {
    		Posicion newPosicion = Posicion.addCoordinates(posicion, 0, 1);
    		return newPosicion;
    	}
    }

    
    /*

    public Direccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public Direccion procesarComando(String command) {
        if (command.equals("l")) {
            return girarIzquierda();
        } else if (command.equals("r")) {
            return girarDerecha();
        } else {
            return this;
        }
    }

    private Direccion girarIzquierda() {
        switch (direccion) {
            case "South":
                return new Direccion("East");
            case "North":
                return new Direccion("West");
            case "West":
                return new Direccion("South");
            case "East":
                return new Direccion("North");
            default:
                return this;
        }
    }

    private Direccion girarDerecha() {
        switch (direccion) {
            case "South":
                return new Direccion("West");
            case "North":
                return new Direccion("East");
            case "West":
                return new Direccion("North");
            case "East":
                return new Direccion("South");
            default:
                return this;
        }
    }
    */
}
