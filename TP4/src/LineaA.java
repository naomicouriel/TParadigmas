package linea;

public class LineaA extends Linea {

    public LineaA(int base, int height) {
        super(base, height, 'A');
    }

    @Override
    public boolean checkHorizontal() {
        return super.checkHorizontal();
    }

    @Override
    public boolean checkVertical() {
        return super.checkVertical();
    }

    @Override
    public boolean checkDiagonal() {
        return super.checkDiagonal();
    }
}
