/*
*Given 4 APIS
clean() : clean the current location
turnLeft(k): turn left k*90 degrees.
turnRight(k): make right turn
move(): return true if can, and vise versa
*/

class CleaningRobot {
	private int[][] direction = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

	public void run() {
		Set<Integer> visited = new HashSet<>();
		dfs(0, 0, visited);
	}

	private void dfs(int row, int col, HashSet<Integer> visited) {
		clean();

		for (int i = 0; i < 4; i++) {
			int x = row + direction[i][0];
			int y = col + direction[i][1];

			if (!visited.contains(hash(x, y)) && move()) {
				visited.add(hash(x, y));
				dfs(x, y, visited);
			}
			turnLeft(2);
		}
		goBack();
	}

	private void hash(int x, int y) {
		return 12 * x + 34 * y;
	}

	private void goBack() {
		turnLeft(2);
		move();
		turnLeft();
	}
}


public class CleaningRobot {
	public void run() {
		Set<Integer> visited = new HashSet<Integer>();
		dfs(0, 0, visited);
	}
	private void dfs(int row, int col, Set<Integer> visited) {
		for(int i = 0; i < 4; i++) {
			int x = row + direction[i][0];
			int y = col + direction[i][1];
			if (move() && !visited.contains(hash(x, y))) {
				dfs(x, y, visited);
			}
			turnLeft();
		}
		goBack();
	}
	private void goBack() {
		turnLeft(2);
		move();
		turnLeft(2);
	}
}