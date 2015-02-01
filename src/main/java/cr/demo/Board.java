package cr.demo;

import java.util.HashSet;
import java.util.Set;

public class Board {
    private Set<Cell> cells = new HashSet<>();

    public void addCell(Cell cell) {
        cells.add(cell);
    }

    public Set<Cell> getNeighbors(Cell cell) {
        Set<Cell> neighbors = new HashSet<>();
        Set<Cell> neighborhood = getNeighborhood(cell);

        for (Cell c : neighborhood) {
            if (isAlive(c)) {
                neighbors.add(c);
            }
        }

        neighbors.remove(cell);

        return neighbors;
    }

    private Set<Cell> getNeighborhood(Cell cell) {
        Set<Cell> neighborhood = new HashSet<>();

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                Cell c = new Cell(cell.x + dx, cell.y + dy);
                neighborhood.add(c);
            }
        }

        return neighborhood;
    }

    boolean isAlive(Cell c) {
        return cells.contains(c);
    }

    public Board nextIteration() {
        Board board = new Board();

        Set<Cell> potentialCellsToBeReborn = new HashSet<>();

        for (Cell c : cells) {
            if (shouldBeAliveInNextIteration(c)) {
                board.addCell(c);
            }

            potentialCellsToBeReborn.addAll(getNeighborhood(c));
        }

        for (Cell c : potentialCellsToBeReborn) {
            if (shouldBeReborn(c)) {
                board.addCell(c);
            }
        }

        return board;
    }

    private boolean shouldBeReborn(Cell c) {
        return !isAlive(c) && getNeighbors(c).size() == 3;
    }

    private boolean shouldBeAliveInNextIteration(Cell c) {
        return getNeighbors(c).size() == 2 || getNeighbors(c).size() == 3;
    }
}
