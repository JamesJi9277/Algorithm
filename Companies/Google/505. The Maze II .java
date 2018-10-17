class Solution {
    private static final int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int shortestDistance(int[][] maze, int[] start, int[] des) {
        if (maze == null) {
            return 0;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{start[0], start[1], 0});
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            if (temp[0] == des[0] && temp[1] == des[1]) {
                return temp[2];
            }
            if (visited[temp[0]][temp[1]]) {
                continue;
            }
            visited[temp[0]][temp[1]] = true;
            for (int[] dir : directions) {
                int x = temp[0];
                int y = temp[1];
                int step = temp[2];
                while (x + dir[0] >= 0 && x + dir[0] < maze.length && y + dir[1] >= 0 && y + dir[1] < maze[0].length && 
                      maze[x + dir[0]][y + dir[1]] != 1) {
                    x += dir[0];
                    y += dir[1];
                    step++;
                }
                pq.offer(new int[]{x, y, step});
            }
        }
        return -1;
    }
}