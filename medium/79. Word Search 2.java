class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null) {
            return false;
        }
        int[][] used = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, word, i, j, 0, used)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean helper(char[][] board, String word, int i, int j, int index, int[][] used) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || used[i][j] == 1 || board[i][j] != word.charAt(index)) {
            return false;
        }
        
        boolean res = false;
        used[i][j] = 1;
        res = helper(board, word, i + 1, j, index + 1, used) || 
            helper(board, word, i - 1, j, index + 1, used) || 
            helper(board, word, i, j + 1, index + 1, used) || 
            helper(board, word, i, j - 1, index + 1, used);
        used[i][j] = 0;
        return res;
    }
}

class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, word, i, j, visited, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean helper(char[][] board, String word, int row, int col, boolean[][] visited, int index) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || 
           word.charAt(index) != board[row][col]) {
            return false;
        }
        visited[row][col] = true;
        boolean res = helper(board, word, row + 1, col, visited, index + 1) || helper(board, word, row - 1, col, visited, index + 1) || helper(board, word, row, col + 1, visited, index + 1) || helper(board, word, row, col - 1, visited, index + 1);
        visited[row][col] = false;
        return res;
    }
}