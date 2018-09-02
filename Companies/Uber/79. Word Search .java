class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean helper(char[][] board, int row, int col, String word, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index) || 
           visited[row][col]) {
            return false;
        }
        visited[row][col] = true;
        boolean res = helper(board, row + 1, col, word, index + 1, visited) || 
            helper(board, row - 1, col, word, index + 1, visited) || 
            helper(board, row, col + 1, word, index + 1, visited) || 
            helper(board, row, col - 1, word, index + 1, visited);
        visited[row][col] = false;
        return res;
    }
}