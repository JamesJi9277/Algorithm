public class Solution {
    class Cell {
        int row;
        int col;
        int ele;
        public Cell(int row, int col, int ele) {
            this.row = row;
            this.col = col;
            this.ele = ele;
        }
    }
    private static final int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int swimInWater(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        PriorityQueue<Cell> pq = new PriorityQueue<>((c1, c2) -> (c1.ele - c2.ele));
        Set<Integer> visited = new HashSet<>();
        pq.offer(new Cell(0, 0, grid[0][0]));
        visited.add(0);
        int totalWait = 0;
        while (!pq.isEmpty()) {
            Cell temp = pq.poll();
            if (temp.ele > totalWait) {
                totalWait = temp.ele;
            }
            if (temp.row == grid.length - 1 && temp.col == grid[0].length - 1) {
                break;
            }
            for (int[] dir : direction) {
                int x = temp.row + dir[0];
                int y = temp.col + dir[1];
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && visited.add(x * grid.length + y)) {
                    pq.offer(new Cell(x, y, grid[x][y]));
                }
            }
        }
        return totalWait;
    }
}