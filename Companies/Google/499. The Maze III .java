class Solution {
    class Point implements Comparable<Point> {
        int x;
        int y;
        int length;
        String path;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.length = Integer.MAX_VALUE;
            this.path = "";
        }
        public Point(int x, int y, int length, String path) {
            this.x = x;
            this.y = y;
            this.length = length;
            this.path = path;
        }
        public int compareTo(Point p) {
            return length == p.length ? path.compareTo(p.path) : length - p.length;
        }
    }
    private static final int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static final String[] directions = new String[]{"d", "u", "r", "l"};
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        if (maze == null) {
            return "";
        }
        PriorityQueue<Point> pq = new PriorityQueue<>();
        Point[][] points = new Point[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                points[i][j] = new Point(i, j);
            }
        }
        pq.offer(new Point(ball[0], ball[1], 0, ""));
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            if (points[p.x][p.y].compareTo(p) <= 0) {
                continue;
            }
            points[p.x][p.y] = p;
            for (int i = 0; i < 4; i++) {
                int x = p.x;
                int y = p.y;
                int step = p.length;
                while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0 && (x != hole[0] || y != hole[1])) {
                    x += dir[i][0];
                    y += dir[i][1];
                    step++;
                }
                if (x != hole[0] || y != hole[1]) {
                    x -= dir[i][0];
                    y -= dir[i][1];
                    step--;
                }
                pq.offer(new Point(x, y, step, p.path + directions[i]));
            }
        }
        return points[hole[0]][hole[1]].length == Integer.MAX_VALUE ? "impossible" : points[hole[0]][hole[1]].path;
    }
}