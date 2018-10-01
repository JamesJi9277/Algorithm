class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    count++;
                    dfs(i, j, board);
                }
            }
        }
        return count;
    }
    private void dfs(int x, int y, char[][] board) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'X') {
            return;
        }
        board[x][y] = '.';
        dfs(x + 1, y, board);
        dfs(x, y + 1, board);
        dfs(x - 1, y, board);
        dfs(x, y - 1, board);
    }
}

class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean isShip = board[i][j] == 'X' ? true : false;
                if ((i != 0 && board[i - 1][j] == 'X') || (j != 0 && board[i][j - 1] == 'X')) {
                    continue;
                } else if (isShip) {
                    count++;
                }
            }
        }
        return count;
    }
}