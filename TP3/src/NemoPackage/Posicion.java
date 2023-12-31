package NemoPackage;

public class Posicion {
	
	private int coordX;
	private int coordY;
	
	public Posicion(int coordX, int coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }
	
	public int getX() {
		return this.coordX;
	}
	
	public int getY() {
		return this.coordY;
	}
	public static Posicion addCoordinates(Posicion pos, int newCoordX, int newCoordY ) {
		return new Posicion(pos.coordX + newCoordX, pos.coordY + newCoordY);
	}
}
