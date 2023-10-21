package NemoPackage;

public abstract class OficialDeProfundidad {
	
	private boolean capsuleIsLiberated;
	int nivel;

	protected abstract Nivel executeUpCommand();
	protected abstract void releaseCapsule();
	protected abstract OficialDeProfundidad executeDownCommand();
	
	abstract class Nivel extends OficialDeProfundidad {
		
	
    class Superficie extends Nivel{

		private int nivel = 0;
    	public int getNivel() {
            return nivel;
        }
    	
        public Nivel executeUpCommand() {
            // Mantener el nivel en la superficie (0)
            return this;
        }
        
        public Nivel executeDownCommand(){
        	return new NivelUno();
        }
        
        public void releaseCapsule() {
        	capsuleIsLiberated = true;
        }
    	
    }
    
    class NivelUno extends Nivel{

    	public int getNivel() {
            return nivel;
        }
    	
    	public Nivel executeUpCommand() {
            // Aumentar en uno el nivel de profundidad (1)
            return new Superficie();
        }

        public Nivel executeDownCommand(){
        	return new NivelMayorAUno();
        }

        public void releaseCapsule() {
        	capsuleIsLiberated = true;
        }
    	
    }
    
    class NivelMayorAUno extends Nivel{
    	
		//private NivelUno nivelAnterior = new NivelUno();
    	public int getNivel() {
            return nivel;
        }
    	public Nivel executeUpCommand() {
            // Aumentar en uno el nivel de profundidad (2 o más)
            return new NivelUno();
        }

        public Nivel executeDownCommand(){
        	return new NivelMayorAUno();
        }

        public void releaseCapsule() {
        	capsuleIsLiberated = false;
        	throw new RuntimeException("No se puede liberar la cápsula en este nivel. Destruyendo submarino en 3... 2... 1...");
        }
    	 
    	
    }

}

    /*

    public Profundidad procesarComando(String command) {
        if (command.equals("d")) {
            return new Profundidad(nivel + 1);
        } else if (command.equals("u")) {
            if (nivel == 0) {
                return new Profundidad(0);
            } else {
                return new Profundidad(nivel - 1);
            }
        } else {
            return this;
        }
    }
    */


}

