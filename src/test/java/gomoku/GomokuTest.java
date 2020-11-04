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
        assertFalse(gomoku.addWhite(-2, 1));
        assertFalse(gomoku.addBlack(-2, 0));
        assertFalse(gomoku.addWhite(-1, 1));
        assertFalse(gomoku.addBlack(-1, 0));
        assertFalse(gomoku.addWhite(0, 1));
        assertFalse(gomoku.addBlack(1, 0));
        assertFalse(gomoku.addWhite(1, 1));
        assertTrue(gomoku.addBlack(2, 0));
    }
    
    @Test
    void diagonalLeftTopRightBottomTest() {
        Gomoku gomoku = new Gomoku();
        assertFalse(gomoku.addWhite(-2, 5));
        assertFalse(gomoku.addBlack(-2, 2));
        assertFalse(gomoku.addWhite(-1, 5));
        assertFalse(gomoku.addBlack(-1, 1));
        assertFalse(gomoku.addWhite(0, 5));
        assertFalse(gomoku.addBlack(1, -1));
        assertFalse(gomoku.addWhite(1, 5));
        assertTrue(gomoku.addBlack(2, -2));
    }
    
    @Test
    void diagonalLeftBottomRightTopTest() {
        Gomoku gomoku = new Gomoku();
        assertFalse(gomoku.addWhite(-2, 5));
        assertFalse(gomoku.addBlack(-2, -2));
        assertFalse(gomoku.addWhite(-1, 5));
        assertFalse(gomoku.addBlack(-1, -1));
        assertFalse(gomoku.addWhite(0, 5));
        assertFalse(gomoku.addBlack(1, 1));
        assertFalse(gomoku.addWhite(1, 5));
        assertTrue(gomoku.addBlack(2, 2));
    }
    
    @Test
    void verticalTest() {
        Gomoku gomoku = new Gomoku();
        assertFalse(gomoku.addWhite(-2, 5));
        assertFalse(gomoku.addBlack(0, 2));
        assertFalse(gomoku.addWhite(-1, 5));
        assertFalse(gomoku.addBlack(0, 1));
        assertFalse(gomoku.addWhite(0, 5));
        assertFalse(gomoku.addBlack(0, -1));
        assertFalse(gomoku.addWhite(1, 5));
        assertTrue(gomoku.addBlack(0, -2));
    }
}
