package linea;

public class EstrategiaB extends Estrategia {
	private char key = 'B';

	public boolean checkWin(Linea linea) {
		return linea.checkWinDiagonal();
	}

	public char getKey() {
		return key;
	}

}
