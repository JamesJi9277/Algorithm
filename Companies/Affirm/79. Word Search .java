class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (helper(board, word, i, j, 0, new HashSet<Integer>())) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean helper(char[][] board, String word, int x, int y, int index, Set<Integer> visited) {
        if (index == word.length()) {
            return true;
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(index) || visited.contains(x * board[0].length + y)) {
            return false;
        }
        visited.add(x * board[0].length + y);
        boolean res = helper(board, word, x + 1, y, index + 1, visited)
            || helper(board, word, x - 1, y, index + 1, visited)
            || helper(board, word, x, y + 1, index + 1, visited)
            || helper(board, word, x, y - 1, index + 1, visited);
        visited.remove(x * board[0].length + y);
        return res;
    }
}