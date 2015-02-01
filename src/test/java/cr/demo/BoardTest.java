package cr.demo;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;

public class BoardTest {
    @Test
    public void aSingleCellShouldHaveZeroNeighbors() throws Exception {
        // given
        Board board = new Board();
        board.addCell(new Cell(0, 0));

        // when
        Set<Cell> neighbors = board.getNeighbors(new Cell(0, 0));

        // then
        assertEquals(0, neighbors.size());
    }

    @Test
    public void twoCellsNextToEachOtherShouldBeNeighbors() throws Exception {
        // given
        Cell first = new Cell(0, 0);
        Cell second = new Cell(0, 1);
        Board board = new Board();
        board.addCell(first);
        board.addCell(second);

        // when
        Set<Cell> neighborsOfFirstCell = board.getNeighbors(first);
        Set<Cell> neighborsOfSecondCell = board.getNeighbors(second);

        // then
        assertArrayEquals(new Cell[] { second }, neighborsOfFirstCell.toArray());
        assertArrayEquals(new Cell[] { first }, neighborsOfSecondCell.toArray());
    }

    @Test
    public void aTwoSingleCellsFarFromEachOtherShouldHaveZeroNeighbors() throws Exception {
        // given
        Board board = new Board();
        board.addCell(new Cell(0, 0));
        board.addCell(new Cell(0, 100));

        // when
        Set<Cell> neighbors = board.getNeighbors(new Cell(0, 0));

        // then
        assertEquals(0, neighbors.size());
    }

    @Test
    public void middleCellOf3x3BlockShouldHaveEightNeighbors() throws Exception {
        // given
        Board board = createBlockBoard(3, 3);

        // when
        Set<Cell> neighbors = board.getNeighbors(new Cell(1, 1));

        // then
        assertEquals(8, neighbors.size());
    }

    public static Board createBlockBoard(int W, int H) {
        Board board = new Board();
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < H; j++) {
                board.addCell(new Cell(i, j));
            }
        }
        return board;
    }
}
