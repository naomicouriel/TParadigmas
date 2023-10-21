package NemoPackage;

import java.util.Arrays;
import java.util.List;

import NemoPackage.Comando.Command;
import NemoPackage.OficialDeProfundidad.Nivel;


public abstract class Comando {
	
	public static List<Command> commandsList = Arrays.asList(new turnLeft(), new turnRight(), new goUp(), new goDown(), new goForward(), new releaseCapsule());

	public interface Command {
	    char getKey();
	}

    public static Object commandFor(char comando){
    	return commandsList
                .stream()
                .filter(command -> isKeyMatch(command, comando))
                .findFirst()
                .orElse(null);
    	 //se fija en la lista de comandos (con un stream) y busca el comando para el char ingresado
    }

    public static boolean isKeyMatch(Command command, char comando) {
        return command.getKey() == comando;
    	//chequea si la key del comando coincide con esta letra
    }
	    
    static class turnLeft extends Comando implements Command {
    	public char key = 'l';
    	
        public char getKey() {
            return key;
        }
        public Direccion execute(Direccion direccion) {
        	return direccion.executeLeftCommand();
        }
    }
    static class turnRight extends Comando implements Command{
    	public char key = 'r';
    	
        public char getKey() {
            return key;
        }
        public Direccion execute(Direccion direccion) {
        	return direccion.executeRightCommand();
        }   
    }
    static class goUp extends Comando implements Command{
    	public char key = 'u';
    	
        public char getKey() {
            return key;
        }
        
        public OficialDeProfundidad execute(Nivel nivel) {
            return nivel.executeUpCommand();
        }
    }
    static class goDown extends Comando implements Command{
    	public char key = 'd';
    	
        public char getKey() {
            return key;
        }
        
        public OficialDeProfundidad execute(Nivel nivel) {
            return nivel.executeDownCommand();
        }
    }
    static class goForward extends Comando implements Command{
    	public char key = 'f';
    	
        public char getKey() {
            return key;
        }
        
        public Posicion execute(Direccion direccion, Posicion posicion) {
        	return direccion.avanzar(posicion);
        }
    }

    static class releaseCapsule extends Comando implements Command{
    	public char key = 'm';
    	
        public char getKey() {
            return key;
        }
        public void execute (Nivel nivel) {
        	 nivel.releaseCapsule();
        }
    }
    
    }
