package NemoPackage;

class West extends Direccion {

	public String direccion = "West";
	
	public String getDireccion() {
		return direccion;
	}
	
	public Direccion executeLeftCommand() {
		return new South();
	}
	
	public Direccion executeRightCommand() {
		return new North();
	}

	public Posicion avanzar(Posicion posicion) {
		Posicion newPosicion = Posicion.addCoordinates(posicion, 0, 1);
		return newPosicion;
	}
}

