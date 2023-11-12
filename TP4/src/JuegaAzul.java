package linea;

public class JuegaAzul extends Estado{

	private Linea linea;
	private char letraAzul = '0';

	public JuegaAzul(Linea linea) {
		super(linea);
		this.linea = linea;
	}

	public Estado playAzul(int col) {
		linea.playAt(col, letraAzul );
		Estado nuevoTurno = cambiarTurno();
		return nuevoTurno;
	}

	protected Estado cambiarTurno() {
		return new JuegaRojo(linea);
	}

	public String getLastPlayer() {
		return "Rojo";
	}

	public boolean isGameFinished() {
		return false;
	}

}