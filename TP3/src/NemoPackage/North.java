package NemoPackage;

 class North extends Direccion {

	public String direccion = "North";
	
	public String getDireccion() {
		return direccion;
	}
	
	public Direccion executeLeftCommand() {
		return new West();
	}
	
	public Direccion executeRightCommand() {
		return new East();
	}

	public Posicion avanzar(Posicion posicion) {
		Posicion newPosicion = Posicion.addCoordinates(posicion, 1, 0);
		return newPosicion;
	}
}
