package linea;

public abstract class Estado {
	
	public Estado(Linea linea) {}
	
	public Estado playRojo(int col) 
		{
		throw new RuntimeException(Linea.ItIsNotYourTurn);
		}
	
	public Estado playAzul(int col) {
		throw new RuntimeException(Linea.ItIsNotYourTurn);
		}
	
	protected abstract Estado cambiarTurno();
	public abstract String getLastPlayer();
	public abstract boolean isGameFinished();

}