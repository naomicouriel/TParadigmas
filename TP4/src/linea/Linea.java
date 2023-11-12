package linea;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Linea {
	
	public static String CannotPlayAtThisPosition = "Esa posición no existe";
	public static String ItIsNotYourTurn = "No es tu turno";
	public static String GameIsOver = "El juego terminó";

	private List<List> tablero = new ArrayList<List>();
    private int base;
    private int altura;
    private Estrategia estrategia = new EstrategiaB();
    private Estado estado = new JuegaRojo(this);
    
    public Linea(int base, int altura, char modoDeJuego) {
        this.base = base;
        this.altura = altura;
        estrategia = estrategia.estrategiaWith(modoDeJuego);
        initializeBoard();
    }

    private void initializeBoard() {
        tablero = IntStream.range(0, altura)
                .mapToObj(i -> IntStream.range(1, base + 1) 
                        .mapToObj(j -> "-")
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }


    public String show() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < altura; i++) {
            List<String> fila = tablero.get(i);
            for (int j = 1; j <= base; j++) {
                result.append(fila.get(j - 1)).append(" ");
            }
            result.append("\n");
        }

        return result.toString();
    }

    public boolean finished() {
        return estrategia.checkWin(this) || empate();
    }

	public void playBlueAt(int col) {
    if(checkDimensiones(col)) {
    	estado = estado.playAzul(col);
    }
    else {
    	throw new RuntimeException(CannotPlayAtThisPosition);
    }
    }

	public void playRedAt(int col) {
	    if(checkDimensiones(col)) {
	    estado = estado.playRojo(col);
	    }
	    else {
	    	throw new RuntimeException(CannotPlayAtThisPosition);
	    }
	    
    }

	public void playAt(int column, char player) {
	    for (int i = altura - 1; i >= 0; i--) {
	        List<String> fila = tablero.get(i);
	        if (fila.get(column - 1).equals("-")) {
	            fila.set(column - 1, String.valueOf(player));
	            break;
	        }
	    }
	}

	public char getEstrategia() {
		return estrategia.getKey();
	}

    private boolean checkDimensiones(int columna) {
    	return columna > 0 && columna <= base;
	}
    
    protected boolean checkWinHorizontal() {
    	boolean hasWinner = tablero.stream()
                .anyMatch(fila -> IntStream.range(0, base - 3)
                        .anyMatch(j -> !fila.get(j).equals("-") &&
                                fila.get(j).equals(fila.get(j + 1)) &&
                                fila.get(j).equals(fila.get(j + 2)) &&
                                fila.get(j).equals(fila.get(j + 3))));
    	if (hasWinner) {
            whoWon();
            estado = new JuegoTerminado(this);
        }
        return hasWinner;
    }

    protected boolean checkWinVertical() {
         boolean hasWinner = IntStream.range(0, base)
                .anyMatch(j -> IntStream.range(0, altura - 3)
                        .anyMatch(i -> !tablero.get(i).get(j).equals("-") &&
                                tablero.get(i).get(j).equals(tablero.get(i + 1).get(j)) &&
                                tablero.get(i).get(j).equals(tablero.get(i + 2).get(j)) &&
                                tablero.get(i).get(j).equals(tablero.get(i + 3).get(j))));
         if (hasWinner) {
             whoWon();
             estado = new JuegoTerminado(this);
         }
         return hasWinner;
    }
    
    protected boolean checkWinDiagonal() {
        boolean hasWinner = IntStream.range(0, altura - 3)
                .anyMatch(i -> IntStream.range(0, base)
                        .anyMatch(j -> !tablero.get(i).get(j).equals("-") &&
                                ((j + 3 < base &&
                                        tablero.get(i).get(j).equals(tablero.get(i + 1).get(j + 1)) &&
                                        tablero.get(i).get(j).equals(tablero.get(i + 2).get(j + 2)) &&
                                        tablero.get(i).get(j).equals(tablero.get(i + 3).get(j + 3))) ||
                                 (j - 3 >= 0 &&
                                        tablero.get(i).get(j).equals(tablero.get(i + 1).get(j - 1)) &&
                                        tablero.get(i).get(j).equals(tablero.get(i + 2).get(j - 2)) &&
                                        tablero.get(i).get(j).equals(tablero.get(i + 3).get(j - 3))))));
        if (hasWinner) {
            whoWon();
            estado = new JuegoTerminado(this);
        }
        return hasWinner;
    }

    public String whoWon() {
    	String ganador = "Ganador: " + estado.getLastPlayer();
    	System.out.println(ganador);
    	return ganador;
	}
 
    public boolean empate() {
        boolean isTie = tablero.stream()
                .flatMap(List::stream)
                .noneMatch(cuadrado -> cuadrado.equals("-"));

        if (isTie) {
            System.out.println("Es un empate");
            estado = new JuegoTerminado(this);
        }

        return isTie;
    }


}
