package cr.demo;

public class Game {
    private Board board;

    public Game(Board board) {
        this.board = board;
    }

    public Board nextIteration() {
        Board nextBoard = board.nextIteration();
        board = nextBoard;

        return board;
    }

    public void print(int size) {
        for (int i = -size; i < size; i++) {
            for (int j = -size; j < size; j++) {
                System.out.print(board.isAlive(new Cell(i, j)) ? 'X' : ' ');
            }

            System.out.println();
        }
    }
}
