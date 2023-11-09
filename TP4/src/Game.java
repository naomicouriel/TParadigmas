package linea;

public class Game {

    public static void main(String[] args) throws Exception {

        System.out.println("Dimensiones?");
        Linea game = createGame();
        
        System.out.println(game.show());

        while (!game.finished()) {
            playTurn(game, new JugadorRojo());
            System.out.println(game.show());

            if (!game.finished()) {
                playTurn(game, new JugadorAzul());
                System.out.println(game.show());
            }
        }
    }

    private static Linea createGame() {
        int base = prompt("Base? ");
        int height = prompt("Altura? ");
        char winVariant = prompt("Variante (A/B/C)? ").charAt(0);

        switch (winVariant) {
            case 'A':
                return new LineaA(base, height);
            case 'B':
                return new LineaB(base, height);
            case 'C':
                return new LineaC(base, height);
            default:
                throw new IllegalArgumentException("Variante no válida.");
        }
    }

    private static void playTurn(Linea game, Jugador player) {
        int column = prompt(player.getSymbol() + "? ");
        boolean validMove;
        
        do {
            validMove = player.getSymbol() == 'R' ? game.playRedAt(column) : game.playBlueAt(column);
            if (!validMove) {
                System.out.println("Columna llena. Elige otra columna.");
                column = prompt(player.getSymbol() + "? ");
            }
        } while (!validMove);
    }

    private static int prompt(String message) {
        System.out.print(message);
        return Integer.parseInt(System.console().readLine());
    }
}
