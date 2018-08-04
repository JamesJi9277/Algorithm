class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n < 0) {
            return res;
        }
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        helper(board, res, 0);
        return res;
    }
    private void helper(char[][] board, List<List<String>> res, int colIndex) {
        if (colIndex == board[0].length) {
            res.add(construct(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (validate(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                helper(board, res, colIndex + 1);
                board[i][colIndex] = '.';
            }
        }
    }
    private boolean validate(char[][] board, int x, int y) {
        // check whether we can place Q or not, three ways contribute
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 'Q') {
                    if (x == i || x + y == i + j || x + j == y + i) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < board[0].length; j++) {
                sb.append(board[i][j]);
            }
            res.add(new String(sb));
        }
        return res;
    }
}