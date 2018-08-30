class TicTacToe {

    int[] rows;// represent sum on every row
    int[] cols; // represent sum on every column
    int leftDown; // only has one row, so can use one parameter to represent
    int rightDown;
    int n;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        leftDown = 0;
        rightDown = 0;
        rows = new int[n];
        cols = new int[n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        rows[row] += (player == 1) ? 1 : -1;
        cols[col] += (player == 1) ? 1 : -1;
        if (row == col) {
            leftDown += (player == 1) ? 1 : -1;
        }
        if (row + col == n - 1) {
            rightDown += (player == 1) ? 1 : -1;
        }
        if (rows[row] == n || cols[col] == n || leftDown == n || rightDown == n) {
            return 1;
        } else if (rows[row] == -n || cols[col] == -n || leftDown == -n || rightDown == -n) {
            return 2;
        } else {
            return 0;
        }
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
// all row and col and cross should have same element
class TicTacToe {

    int[][] board;
    int n;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board = new int[n][n];
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        board[row][col] = player;
        if (checkHorizon(board, player, row, col)) {
            return player;
        }
        if (checkVertical(board, player, row, col)) {
            return player;
        }
        if (checkCross(board, player, row, col)) {
            return player;
        }
        if (checkCross1(board, player, row, col)) {
            return player;
        }
        return 0;
    }
    private boolean checkHorizon(int[][] board, int target, int row, int col) {
        for (int i = 0; i < n; i++) {
            if (board[row][i] != target) {
                return false;
            }
        }
        return true;
    }
    private boolean checkVertical(int[][] board, int target, int row, int col) {
        for (int i = 0; i < n; i++) {
            if (board[i][col] != target) {
                return false;
            }
        }
        return true;
    }
    private boolean checkCross(int[][] board, int target, int row, int col) {
        for (int i = 0; i < n; i++) {
            if (board[i][i] != target) {
                return false;
            }
        }
        return true;
    }
    private boolean checkCross1(int[][] board, int target, int row, int col) {
        for (int i = n - 1; i >= 0; i--) {
            if (board[i][n - 1 - i] != target) {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */