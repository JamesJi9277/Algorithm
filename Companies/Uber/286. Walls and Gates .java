class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    helper(rooms, i, j, 0);
                }
            }
        }
    }
    private void helper(int[][] rooms, int row, int col, int step) {
        if (row < 0 || row >= rooms.length || col < 0 || col >= rooms[0].length || rooms[row][col] == -1 || step > rooms[row][col]) {
            return;
        }
        rooms[row][col] = step;
        helper(rooms, row + 1, col, step + 1);
        helper(rooms, row - 1, col, step + 1);
        helper(rooms, row, col + 1, step + 1);
        helper(rooms, row, col - 1, step + 1);
    }
}
class Solution {
    private static final int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                for (int[] dir : directions) {
                    int x = temp[0] + dir[0];
                    int y = temp[1] + dir[1];
                    if (x >= 0 && x < rooms.length && y >= 0 && y < rooms[0].length && rooms[x][y] != -1 && rooms[x][y] > rooms[temp[0]][temp[1]]) {
                        rooms[x][y] = step;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
    }
}
