package linea;

public class EstrategiaA extends Estrategia{
	private char key = 'A';
	
	public boolean checkWin(Linea linea) {
		return linea.checkWinVertical() || linea.checkWinHorizontal();
	}
	
	public char getKey() {
		return key;
	}

}