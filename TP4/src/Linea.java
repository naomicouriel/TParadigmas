package linea;

public class Linea {

    protected char[][] board;
    protected char winVariant;
    protected int height;
    protected int base;
    protected int currentPlayer;

    public Linea(int base, int height, char winVariant) {
        this.base = base;
        this.height = height;
        this.winVariant = winVariant;
        this.board = new char[height][base];
        initializeBoard();
        currentPlayer = 1;
    }

    private void initializeBoard() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < base; j++) {
                board[i][j] = '-';
            }
        }
    }

    public boolean playRedAt(int column) {
        return playAt(column, 'R');
    }

    public boolean playBlueAt(int column) {
        return playAt(column, 'B');
    }

    private boolean playAt(int column, char player) {
        if (column < 0 || column >= base) {
            return false;
        }

        for (int i = height - 1; i >= 0; i--) {
            if (board[i][column] == '-') {
                board[i][column] = player;
                return true;
            }
        }

        return false;
    }

    public boolean finished() {
        return checkHorizontal() || checkVertical() || checkDiagonal();
    }

    public String show() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < base; j++) {
                result.append(board[i][j]).append(" ");
            }
            result.append("\n");
        }

        return result.toString();
    }

    protected boolean checkHorizontal() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j <= base - 4; j++) {
                if (board[i][j] != '-' &&
                    board[i][j] == board[i][j + 1] &&
                    board[i][j] == board[i][j + 2] &&
                    board[i][j] == board[i][j + 3]) {
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean checkVertical() {
        for (int i = 0; i <= height - 4; i++) {
            for (int j = 0; j < base; j++) {
                if (board[i][j] != '-' &&
                    board[i][j] == board[i + 1][j] &&
                    board[i][j] == board[i + 2][j] &&
                    board[i][j] == board[i + 3][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean checkDiagonal() {
        for (int i = 0; i <= height - 4; i++) {
            for (int j = 0; j <= base - 4; j++) {
                if (board[i][j] != '-' &&
                    (board[i][j] == board[i + 1][j + 1] &&
                    board[i][j] == board[i + 2][j + 2] &&
                    board[i][j] == board[i + 3][j + 3])) {
                    return true;
                }
                if (board[i][j + 3] != '-' &&
                    (board[i][j + 3] == board[i + 1][j + 2] &&
                    board[i][j + 3] == board[i + 2][j + 1] &&
                    board[i][j + 3] == board[i + 3][j])) {
                    return true;
                }
            }
        }
        return false;
    }
}
