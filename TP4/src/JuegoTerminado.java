package linea;

public class JuegoTerminado extends Estado {

	public JuegoTerminado(Linea linea) {
		super(linea);
	}

	protected Estado cambiarTurno() {
		throw new RuntimeException(Linea.GameIsOver);
	}

	public String getLastPlayer() {
		throw new RuntimeException(Linea.GameIsOver);
	}

	public Estado playRojo(int col) 
	{
		throw new RuntimeException(Linea.GameIsOver);
	}

	public Estado playAzul(int col) {
		throw new RuntimeException(Linea.GameIsOver);
	}

	public boolean isGameFinished() {
		return true;
	}

}