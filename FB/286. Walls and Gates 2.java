class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }
    private void dfs(int[][] rooms, int x, int y, int steps) {
        if (x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length || rooms[x][y] == -1) {
            return;
        }
        if (rooms[x][y] >= steps) {
            rooms[x][y] = steps;
            dfs(rooms, x + 1, y, steps + 1);
            dfs(rooms, x - 1, y, steps + 1);
            dfs(rooms, x, y + 1, steps + 1);
            dfs(rooms, x, y - 1, steps + 1);
        }
    }
}

class Solution {
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
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int row = temp[0];
            int col = temp[1];
            // right
            if (col + 1 < rooms[0].length && rooms[row][col + 1] > rooms[row][col]) {
                rooms[row][col + 1] = rooms[row][col] + 1;
                queue.offer(new int[]{row, col + 1});
            }
            // left
            if (col - 1 >= 0 && rooms[row][col - 1] > rooms[row][col]) {
                rooms[row][col - 1] = rooms[row][col] + 1;
                queue.offer(new int[]{row, col - 1});
            }
            // up
            if (row - 1 >= 0 && rooms[row - 1][col] > rooms[row][col]) {
                rooms[row - 1][col] = rooms[row][col] + 1;
                queue.offer(new int[]{row - 1, col});
            }
            // down
            if (row + 1 < rooms.length && rooms[row + 1][col] > rooms[row][col]) {
                rooms[row + 1][col] = rooms[row][col] + 1;
                queue.offer(new int[]{row + 1, col});
            }
        }
    }
}