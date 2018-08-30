class Solution {
    private static final int[][] directions = new int[][]{{1,0},{0,-1},{0,1},{-1,0}};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0 || maze[0].length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        PriorityQueue<Point> pq = new PriorityQueue<Point>();
        pq.offer(new Point(start[0], start[1], 0));
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            if (p.row == destination[0] && p.col == destination[1]) {
                return p.dist;
            }
            visited[p.row][p.col] = true;
            for (int[] dir : directions) {
                int newRow = p.row;
                int newCol = p.col;
                int newDist = p.dist;
                while (newRow + dir[0] >= 0 
                       && newRow + dir[0] < maze.length 
                       && newCol + dir[1] >= 0 
                       && newCol + dir[1] < maze[0].length 
                       && maze[newRow + dir[0]][newCol + dir[1]] != 1) {
                    newRow += dir[0];
                    newCol += dir[1];
                    newDist++;
                }
                if (!visited[newRow][newCol]) {
                    pq.offer(new Point(newRow, newCol, newDist));
                }
            }
        }
        return -1;
    }
    class Point implements Comparable<Point> {
        int dist;
        int row;
        int col;
        public Point (int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
        @Override
        public int compareTo(Point that) {
            return this.dist - that.dist;
        }
    }
}