package linea;

public abstract class Jugador {

    protected char symbol;

    public Jugador(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
