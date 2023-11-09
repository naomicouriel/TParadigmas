package linea;

public class LineaC extends Linea {

    public LineaC(int base, int height) {
        super(base, height, 'C');
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
