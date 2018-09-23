class TicTacToe {

    /** Initialize your data structure here. */
    int[] rows;
    int[] cols;
    int dia;
    int dia1;
    int n;
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        dia = 0;
        dia1 = 0;
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
        if (player == 1) {
            rows[row]++;
            cols[col]++;
            if (col == row) {
                dia++;
            } if (row + col == rows.length - 1) {
                dia1++;
            }
        } else if (player == 2) {
            rows[row]--;
            cols[col]--;
            if (col == row) {
                dia--;
            }  if (row + col == rows.length - 1) {
                dia1--;
            }
        }
        if (rows[row] == n || cols[col] == n || dia == n || dia1 == n) {
            return 1;
        } else if (rows[row] == -n || cols[col] == -n || dia == -n || dia1 == -n) {
            return 2;
        } else {
            return 0;
        }
    }
}