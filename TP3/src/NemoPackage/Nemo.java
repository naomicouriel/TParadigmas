package NemoPackage;

public class Nemo {
    public static String CannotReleaseCapsuleInDeeperLevels = "No se puede liberar la cápsula en otro nivel";
	public int depth = 1;
    public String direction = "South";
    
    public Posicion posicion = new Posicion(0, 0);
    public int posicionX = 0;
    public int posicionY = 0;
    public boolean capsuleIsLiberated = false;
    
    public void setDirection(String directionToSet) {
    	direction = directionToSet;
    }

    public int getPositionX(){
        return posicion.getX();   
    }
    
    public int getPositionY(){
        return posicion.getY();   
    }

    public int getDepth() {
        return depth;
    }

    public String getDirection() {
        return direction;
    }

    public int moveX(String string) {
        return posicion.getX();
    }

    public int moveY(String string) {
        return posicion.getY();
    }
/*
    public int moveDepth(char c) {
        if (c == 'd') {
            depth += 1;
        }
        if (c == 'u') {
            if (getDepth() == 0) {
                depth = 0;
            }
            else {
                depth -= 1;
            }
        }
        return depth;
    }

    public String rotate(char c) {
        if (c == 'l') {
            switch (direction) {
                case "South":
                    direction = "East";
                    break;
                case "North":
                    direction = "West";
                    break;
                case "West":
                    direction = "South";
                    break;
                case "East":
                    direction = "North";
                    break;
            }
        }
          if (c == 'r') {
        	  switch(direction) {
        	  case "South":
                  direction = "West";
                  break;
              case "North":
                  direction = "East";
                  break;
              case "West":
                  direction = "North";
                  break;
              case "East":
                  direction = "South";
                  break;
        	  }
          }
        
        return direction;        
    }

	public int moveFordward(char c) {
		Posicion newposicion = new Posicion(1, 0);
		return newposicion.getX();
	}

	public void releaseCapsule(char c) throws Exception {
		if (depth == 0 || depth == 1) {
			capsuleIsLiberated = true;
		}
		else{
			throw new Exception("No se puede liberar la cápsula en otro nivel");
			//destroy nemo
		}
	}
	*/
	public void processCommand(String command) throws Exception {
		if (command == "d") {
            depth += 1;
        }
        if (command == "u") {
            if (getDepth() == 0) {
                depth = 0;
            }
            else {
                depth -= 1;
            }
        }
        if (command == "l") {
            switch (direction) {
                case "South":
                    direction = "East";
                    break;
                case "North":
                    direction = "West";
                    break;
                case "West":
                    direction = "South";
                    break;
                case "East":
                    direction = "North";
                    break;
            }
        }
          if (command == "r") {
        	  switch(direction) {
        	  case "South":
                  direction = "West";
                  break;
              case "North":
                  direction = "East";
                  break;
              case "West":
                  direction = "North";
                  break;
              case "East":
                  direction = "South";
                  break;
        	  }
          }
          if (command == "f") {
      		//Posicion newposicion = new Posicion(1, 0);
        	  posicionX += 1;
          }
          if(command == "m") {
        	  if (depth == 0 || depth == 1) {
      			capsuleIsLiberated = true;
      		}
      		else{
      			throw new RuntimeException(CannotReleaseCapsuleInDeeperLevels);
      			//destroy nemo
      		}
          }
	}
}
