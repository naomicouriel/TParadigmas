package NemoPackage;

class East extends Direccion {

	public String direccion = "East";
	
	public String getDireccion() {
		return direccion;
	}
	
	public Direccion executeLeftCommand() {
		return new North();
	}
	
	public Direccion executeRightCommand() {
		return new South();
	}

	public Posicion avanzar(Posicion posicion) {
		Posicion newPosicion = Posicion.addCoordinates(posicion, 0, 1);
		return newPosicion;
	}
}