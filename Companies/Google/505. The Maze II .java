class Solution {
    private static final int[][] directions = new int[][]{{1,0},{0,-1},{0,1},{-1,0}};
    public int shortestDistance(int[][] maze, int[] start, int[] end) {
        if (maze == null) {
            return 0;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        pq.offer(new int[]{start[0], start[1], 0});
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int x = temp[0];
            int y = temp[1];
            int step = temp[2];
            if (visited[x][y]) {
                continue;
            }
            visited[x][y] = true;
            if (x == end[0] && y == end[1]) {
                return step;
            }
            for (int[] dir : directions) {
                int row = x;
                int col = y;
                int step1 = temp[2];
                while (row + dir[0] >= 0 && row + dir[0] < maze.length && col + dir[1] >= 0 && col + dir[1] < maze[0].length && maze[row + dir[0]][col + dir[1]] != 1) {
                    row += dir[0];
                    col += dir[1];
                    step1++;
                }
                pq.offer(new int[]{row, col, step1});
            }
        }
        return -1;
    }
}