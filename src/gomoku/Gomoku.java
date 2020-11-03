package gomoku;

import java.util.HashMap;
import java.util.Map;

public class Gomoku {

	private boolean flag = false;
	private Map<Point, String> goban = new HashMap<>();

	public Gomoku() {
		addBlack(0, 0);
	}

	public void addWhite(int x, int y) {
		if (flag) {
			Point p = new Point(x, y);
			goban.put(p, "white");
			flag = false;
		}
	}

	public void addBlack(int x, int y) {
		if (!flag) {
			Point p = new Point(x, y);
			goban.put(p, "black");
			flag = true;
		}
	}

	public boolean horizontal(Point point, String str) {
		Point p = new Point(point.getX() - 4, point.getY());
		int count = 0;
		for (int i = 0; i < 9; i++) {
			if (goban.get(p).equals(str)) {
				count++;
			} else {
				count = 0;
			}
			p.setX(p.getX() + 1);
		}
		if (count >= 5) {
			return true;
		}
		return false;
	}

	public boolean vertical(Point point, String str) {
		Point p = new Point(point.getX(), point.getY() - 4);
		int count = 0;
		for (int i = 0; i < 9; i++) {
			if (goban.get(p).equals(str)) {
				count++;
			} else {
				count = 0;
			}
			p.setY(p.getY() + 1);
		}
		if (count >= 5) {
			return true;
		}
		return false;
	}

	public boolean giagonal(Point point, String str) {
		Point p = new Point(point.getX() - 4, point.getY() - 4);
		int count = 0;
		for (int i = 0; i < 9; i++) {
			if (goban.get(p).equals(str)) {
				count++;
			} else {
				count = 0;
			}
			p.setY(p.getY() + 1);
			p.setY(p.getY() + 1);
		}
		if (count >= 5) {
			return true;
		}
		return false;
	}

	public boolean isWinner(Point point, String str) {
		if (giagonal(point, str) || horizontal(point, str) || vertical(point, str)) {
			return true;
		}
		return false;
	}
}
