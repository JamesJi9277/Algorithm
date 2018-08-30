class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int neighbors = getNeighbors(board, i, j);
                if (board[i][j] == 1 && (neighbors == 2 || neighbors == 3)) {
                    board[i][j] = 3;
                } else if (board[i][j] == 0 && neighbors == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }
    private int getNeighbors(int[][] board, int i, int j) {
        int count = 0;
        for (int h = Math.max(i - 1, 0); h <= Math.min(board.length - 1, i + 1); h++) {
            for (int k = Math.max(j - 1, 0); k <= Math.min(board[0].length - 1, j + 1); k++) {
                count += board[h][k] & 1;
            }
        }
        return count - (board[i][j] & 1);
    }
}