class Solution {
    private static final int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();;
            for (int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                for (int[] dir : directions) {
                    int x = temp[0] + dir[0];
                    int y = temp[1] + dir[1];
                    if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] > matrix[temp[0]][temp[1]]) {
                        queue.offer(new int[]{x, y});
                        matrix[x][y] = matrix[temp[0]][temp[1]] + 1;
                    }
                }
            }
        }
        return matrix;
    }
}