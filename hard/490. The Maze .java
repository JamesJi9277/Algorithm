class Solution {
    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return false;
        }
        if (start == destination) {
            return true;
        }
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Stack<int[]> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int row = cur[0];
            int col = cur[1];
            if (visited[row][col]) {
                continue;
            }
            visited[row][col] = true;
            for (int[] dir : directions) {
                int x = row;
                int y = col;
                while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] != 1) {
                    x += dir[0];
                    y += dir[1];
                }
                x -= dir[0];
                y -= dir[1];
                stack.push(new int[]{x, y});
            }
        }
        return visited[destination[0]][destination[1]];
    }
}