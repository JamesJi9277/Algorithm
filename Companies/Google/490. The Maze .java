class Solution {
    private static final int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return false;
        }
        Stack<int[]> stack = new Stack<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        stack.push(start);
        while (!stack.isEmpty()) {
            int[] temp = stack.pop();
            int x = temp[0];
            int y = temp[1];
            if (x == destination[0] && y == destination[1]) {
                return true;
            }
            if (visited[x][y]) {
                continue;
            }
            visited[x][y] = true;
            for (int[] dir : directions) {
                x = temp[0];
                y = temp[1];
                while (x + dir[0] >= 0 && x + dir[0] < maze.length && y + dir[1] >= 0 && y + dir[1] < maze[0].length
                      && maze[x + dir[0]][y + dir[1]] != 1) {
                    x += dir[0];
                    y += dir[1];
                }
                stack.push(new int[]{x, y});
            }
        }
        return false;
    }
}