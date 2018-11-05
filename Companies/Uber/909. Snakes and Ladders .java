class Solution {
    public int snakesAndLadders(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }
        int n = board.length;
        int[] array = new int[n * n];
        int index = 0;
        int i = n - 1;
        int j = 0;
        int offset = 1;
        while (index < n * n) {
            array[index++] = board[i][j];
            if (offset == 1 && j == n - 1) {
                i--;
                offset = -1;
            } else if (offset == -1 && j == 0) {
                offset = 1;
                i--;
            } else {
                j += offset;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        int start = array[0] == -1 ? 0 : array[0] - 1;
        int step = 0;
        boolean[] visited = new boolean[n * n];
        visited[start] = true;
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int temp = queue.poll();
                if (temp == n * n - 1) {
                    return step;
                }
                for (int m = 1; m <= 6 && temp + m < n * n; m++) {
                    int next = array[temp + m] == -1 ? temp + m : array[temp + m] - 1;
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}