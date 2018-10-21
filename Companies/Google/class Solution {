class Solution {
    class Cell {
        int key;
        int x;
        int y;
        public Cell(int key, int x, int y) {
            this.key = key;
            this.x = x;
            this.y = y;
        }
    }
    public int shortestPathAllKeys(String[] grid) {
        int row = 0;
        int col = 0;
        int max = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    row = i;
                    col = j;
                }
                if (c >= 'a' && c <= 'f') {
                    max = Math.max(max, c - 'a' + 1);
                }
            }
        }
        Cell start = new Cell(0, row, col);
        Queue<Cell> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(0 + "" + row + "" + col);
        queue.offer(start);
        int step = 0;
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Cell temp = queue.poll();
                if (temp.key == (1 << max) - 1) {
                    return step;
                }
                for (int[] dir : dirs) {
                    int i = temp.x + dir[0];
                    int j = temp.y + dir[1];
                    int key = temp.key;
                    if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length()) {
                        char c = grid[i].charAt(j);
                        if (c == '#') {
                            continue;
                        }
                        if (c >= 'a' && c <= 'f') {
                            key |= (1 << (c - 'a'));
                        }
                        if ((c >= 'A' && c <= 'F') && ((key >> (c - 'A')) & 1) == 0) {
                            continue;
                        }
                        if (!visited.contains(key + "" + i + "" + j)) {
                            visited.add(key + "" + i + "" + j);
                            queue.offer(new Cell(key, i, j));
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}