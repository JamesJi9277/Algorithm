class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int neighbor = helper(board, i, j);
                if (board[i][j] == 1 && (neighbor == 2 || neighbor == 3)) {
                    board[i][j] = 3;
                } else if (board[i][j] == 0 && neighbor == 3) {
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
    private int helper(int[][] board, int row, int col) {
        int count = 0;
        for (int i = Math.max(0, row - 1); i <= Math.min(board.length - 1, row + 1); i++) {
            for (int j = Math.max(0, col - 1); j <= Math.min(board[0].length - 1, col + 1); j++) {
                count += board[i][j] & 1;
            }
        }
        if (board[row][col] == 0) {
            return count;
        } else {
            return count - 1;
        }
    }
}