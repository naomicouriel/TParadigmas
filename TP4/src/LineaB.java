package linea;

public class LineaB extends Linea {

    public LineaB(int base, int height) {
        super(base, height, 'B');
    }

    @Override
    public boolean checkHorizontal() {
        return false;
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
