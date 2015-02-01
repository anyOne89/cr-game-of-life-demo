package cr.demo;

import org.junit.Test;

public class GameTest {
    @Test
    public void shouldProcessMultipleIterations() throws Exception {
        // given
        Game game = new Game(BoardTest.createBlockBoard(3, 3));

        // when
        for (int i = 0; i < 30; i++) {
            game.print(10);
            game.nextIteration();
            Thread.sleep(400);
        }

        // then

    }
}
