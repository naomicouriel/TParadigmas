package linea;

public class JuegaRojo extends Estado {

	private Linea linea;
	private char letraRojo =  'X';

	public JuegaRojo(Linea linea) {
		super(linea);
		this.linea = linea;
	}
	
	public Estado playRojo(int col) {
		//Juega (agrega a la lista)
		linea.playAt(col, letraRojo);
		Estado nuevoTurno = cambiarTurno();
		return nuevoTurno;
	}

	protected Estado cambiarTurno() {
	    return new JuegaAzul(linea);
	}

	public String getLastPlayer() {
		return "Azul";
	}

	public boolean isGameFinished() {
		return false;
	}

}