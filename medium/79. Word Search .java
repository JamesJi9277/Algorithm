class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }
        int[][] used = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, used, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean helper(char[][] board, int[][] used, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || used[i][j] == 1 || board[i][j] != word.charAt(index)) {
            return false;
        }
        used[i][j] = 1;
        boolean res = helper(board, used, word, i + 1, j, index + 1) || 
            helper(board, used, word, i - 1, j, index + 1) ||
            helper(board, used, word, i, j + 1, index + 1) ||
            helper(board, used, word, i, j - 1, index + 1);
        used[i][j] = 0;
        return res;
    }
}