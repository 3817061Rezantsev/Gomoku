package gomoku;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GomokuTest {

    @Test
    void isWinnerTest() {
        Gomoku gomoku = new Gomoku();
        assertFalse(gomoku.isWinner(new Position(0, 0), false));
    }

    @Test
    void moveTest() {
        Gomoku gomoku = new Gomoku();

        Boolean color = gomoku.getColor(0, 0);
        assertNotNull(color);
        assertFalse(color);

        gomoku.addBlack(1, 1);
        color = gomoku.getColor(1, 1);
        assertNull(color);

        gomoku.addWhite(0, 0);
        color = gomoku.getColor(0, 0);
        assertNotNull(color);
        assertFalse(color);

        gomoku.addWhite(1, 1);
        color = gomoku.getColor(1, 1);
        assertNotNull(color);
        assertTrue(color);
    }

    @Test
    void horizontalTest() {
        Gomoku gomoku = new Gomoku();
        gomoku.addWhite(1, 1);
    }
}
