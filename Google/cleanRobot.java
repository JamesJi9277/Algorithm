/*
*Given 4 APIS
clean() : clean the current location
turnLeft(k): turn left k*90 degrees.
turnRight(k): make right turn
move(): return true if can, and vise versa
*/
public class CleaningRobot {
	private int[][] direction = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

	public void run() {
		Set<Integer> visited = new HashSet<>();
		dfs(0, 0, visited);//假定从起点开始,x = 0, y = 0
	}

	private void dfs(int row, int col, HashSet<Integer> visited) {
		visited.add(hash(row, col));
		clean();//自带的方法，表示清洁当前的xy 空格

		for (int i = 0; i < 4; i++) {
			int x = row + direction[i][0];
			int y = col + direction[i][1];
			if (!visit.contains(hash(x, y)) && move()) {
				dfs(x, y, visited);
			}
			turnLeft(1);
		}
		goBack();
	}

	private void goBack() {
		turnLeft(2);
		move();
		turnLeft(2);
	}

	private int hash(int x, int y) {
		return 12 * x + 34 * y;
	}
}