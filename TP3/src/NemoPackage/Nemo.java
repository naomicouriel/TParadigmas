package NemoPackage;

public class Nemo {
	public String south;
	public int depth = 0;
	public String direction = "South";
	
	public Posicion posicion = new Posicion(0, 0);

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
			if (direction == "South") {
				direction = "East";
			}
			if (direction == "North") {
				direction = "West";
			}
			if (direction == "West") {
				direction = "South";
			}
			if (direction == "East") {
				direction = "North";
			}
			
		}
		return direction;		
	}
}