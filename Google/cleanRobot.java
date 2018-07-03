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
				visited.add(hash(x, y));
				clean();
				dfs(x, y, visited);
				goBack();
			}
			turnLeft();
		}
		goBack();
	}
	private void goBack() {
		turnLeft(2);
		move();
		tuenLeft(2);
	}
}


public class CleaningRobot {
	int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	public void clean(int[][] room, int[] start) {
		if (room == null || room.length == 0 || room[0].length == 0) {
			return;
		}
		Set<Integer> visited = new HashSet<>();
		dfs(room, start[0], start[1], visited);
	}
	private void dfs(int[][] room, int row, int col, Set<Integer> visited) {
		if (row < 0 || row >= room.length || col < 0 || col >= room[0].length || visited.contains(hash(row, col))) {
			return;
		}
		for (int[] dir : directions) {
			int x = row + dir[0];
			int y = col + dir[1];
			if (!visited.contains(hash(x, y))) {
				move(row, col, x, y);
				visited.add(hash(x, y));
				clean();
				dfs(room, x, y, visited);
				move(x, y, row, col);//move back
			}
		}
	}
}