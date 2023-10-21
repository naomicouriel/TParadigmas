package NemoPackage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import NemoPackage.Comando.Command;

public class Nemo2 {
    public static String CannotReleaseCapsuleInDeeperLevels = "No se puede liberar la cápsula en otro nivel";

    private Profundidad profundidad = new Profundidad();
    private Direccion direccion;
    private Posicion posicion;
    private boolean capsuleIsLiberated;
    
    public Nemo2(Posicion posicion, Direccion direccion) {
        this.direccion = direccion;
        this.posicion = posicion;
        capsuleIsLiberated = false;
    }

    public int getPositionX() {
        return posicion.getX();
    }
  
    public int getPositionY() {
        return posicion.getY();
    }

    public int getDepth() {
        return profundidad.nivel;
    }

    public String getDirection() {
        return direccion.direction;
    }
/*
    public void processCommand(String command) throws Exception {
        profundidad = profundidad.procesarComando(command);
        direccion = direccion.procesarComando(command);
        posicion = posicion.procesarComando(command);

        if (command.equals("m")) {
            if (profundidad.getNivel() == 0 || profundidad.getNivel() == 1) {
                capsuleIsLiberated = true;
            } else {
                throw new RuntimeException(CannotReleaseCapsuleInDeeperLevels);
            }
        }
    }
    */
    public void move(String comandos) {
    	comandos.chars()
        .forEach(command -> move((char) command));
    	//Separar el string en chars y con cada caracter hacer un move
    }
    public void move(char c) {
    	Comando.commandFor(c).execute(this);
    }
    
}

