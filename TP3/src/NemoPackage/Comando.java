package NemoPackage;

import java.util.Arrays;
import java.util.List;

public abstract class Comando {
	
	public static List<Comando> commandsList = Arrays.asList(new turnLeft(), new turnRight(), new goUp(), new goDown(), new goForward(), new releaseCapsule());

	abstract char getKey();
	abstract void execute(Nemo nemo);

    public static Comando commandFor(char comando){
    	return commandsList
                .stream()
                .filter(command -> isKeyMatch(command, comando))
                .findFirst()
                .orElse(null);
    }

    public static boolean isKeyMatch(Comando command, char comando) {
        return command.getKey() == comando;
    }
    	    
 }
