package gomoku;

import java.util.HashMap;
import java.util.Map;

public class Gomoku {

    private boolean colorToMove = false; // false - black, true - white
    private Map<Position, Boolean> goban = new HashMap<>();

    public Gomoku() {
        addBlack(0, 0);
    }

    public boolean addWhite(int x, int y) {
        return move(x, y, true);
    }

    public boolean addBlack(int x, int y) {
        return move(x, y, false);
    }

    protected boolean move(int x, int y, Boolean color) {
        Position position = new Position(x, y);
        if (colorToMove == color && goban.get(position) == null) {
            goban.put(position, color);
            colorToMove = !colorToMove;
        }
        return isWinner(position, color);
    }

    protected boolean horizontal(Position p, Boolean color) {
        Position position = new Position(p.getX() - 4, p.getY());
        int count = 0;
        for (int i = 0; i < 9; i++) {
            if (goban.get(position) != null && goban.get(position).equals(color)) {
                count++;
            } else {
                count = 0;
            }
            position.setX(position.getX() + 1);
        }
        return count >= 5;
    }

    protected boolean vertical(Position p, Boolean color) {
        Position position = new Position(p.getX(), p.getY() - 4);
        int count = 0;
        for (int i = 0; i < 9; i++) {
            if (goban.get(position) != null && goban.get(position).equals(color)) {
                count++;
            } else {
                count = 0;
            }
            position.setY(position.getY() + 1);
        }
        return count >= 5;
    }

    protected boolean diagonal(Position p, Boolean color) {
        Position position = new Position(p.getX() - 4, p.getY() - 4);
        int count = 0;
        for (int i = 0; i < 9; i++) {
            if (goban.get(position) != null && goban.get(position).equals(color)) {
                count++;
            } else {
                count = 0;
            }
            position.setY(position.getY() + 1);
            position.setY(position.getY() + 1);
        }
        return count >= 5;
    }

    protected boolean isWinner(Position p, Boolean color) {
        return diagonal(p, color) || horizontal(p, color) || vertical(p, color);
    }

    protected Boolean getColor(int x, int y) {
        return goban.get(new Position(x, y));
    }
}
