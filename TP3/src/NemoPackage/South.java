package NemoPackage;

class South extends Direccion{
	public String direccion = "South";
	
	public String getDireccion() {
		return direccion;
	}
	
	public Direccion executeLeftCommand() {
		return new East();
	}
	
	public Direccion executeRightCommand() {
		return new West();
	}
	
	public Posicion avanzar(Posicion posicion) {
		Posicion newPosicion = Posicion.addCoordinates(posicion, 1, 0);
		return newPosicion;
	}
	
}
