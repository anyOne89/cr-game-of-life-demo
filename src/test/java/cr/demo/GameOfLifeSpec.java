package cr.demo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GameOfLifeSpec {

    @Test
    public void aSingleCellShouldDieInNextIteration() throws Exception {
        // given
        Board board = new Board();
        board.addCell(new Cell(0, 0));
        Game game = new Game(board);

        // when
        Board nextBoard = game.nextIteration();

        // then
        assertFalse(nextBoard.isAlive(new Cell(0, 0)));
    }

    @Test
    public void cellWithTwoNeighborsShouldLiveInNextIteration() throws Exception {
        // given
        Board board = new Board();
        board.addCell(new Cell(0, 1));
        board.addCell(new Cell(1, 1));
        board.addCell(new Cell(1, 0));
        Game game = new Game(board);

        // when
        Board nextBoard = game.nextIteration();

        // then
        assertTrue(nextBoard.isAlive(new Cell(1, 1)));
    }

    @Test
    public void cellWithThreeNeighborsShouldLiveInNextIteration() throws Exception {
        // given
        Board board = new Board();
        board.addCell(new Cell(0, 1));
        board.addCell(new Cell(1, 1));
        board.addCell(new Cell(1, 0));
        board.addCell(new Cell(0, 0));
        Game game = new Game(board);

        // when
        Board nextBoard = game.nextIteration();

        // then
        assertTrue(nextBoard.isAlive(new Cell(1, 1)));
    }

    @Test
    public void cellWithMoreThanThreeNeighborsShouldDieInNextIteration() throws Exception {
        // given
        Game game = new Game(BoardTest.createBlockBoard(3, 3));

        // when
        Board nextBoard = game.nextIteration();

        // then
        assertFalse(nextBoard.isAlive(new Cell(1, 1)));
    }


    @Test
    public void aDeadCellWithThreeNeighborsShouldBeRebornInNextIteration() throws Exception {
        // given
        Board board = new Board();
        board.addCell(new Cell(0, 1));
        board.addCell(new Cell(1, 1));
        board.addCell(new Cell(1, 0));
        Game game = new Game(board);

        // when
        Board nextBoard = game.nextIteration();

        // then
        assertTrue(nextBoard.isAlive(new Cell(0, 0)));
    }
}
