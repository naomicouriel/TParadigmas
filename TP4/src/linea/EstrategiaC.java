package linea;

public class EstrategiaC extends Estrategia{
	private char key = 'C';

	@Override
	public boolean checkWin(Linea linea) {
		return linea.checkWinVertical() || linea.checkWinHorizontal() || linea.checkWinDiagonal();
	}

	@Override
	public char getKey() {
		return key;
	}

}
