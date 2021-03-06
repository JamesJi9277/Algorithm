public class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        int count = 0;
        int row = click[0];
        int col = click[1];
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int x = row + i;
                int y = col + j;
                if (x == row && y == col) {
                    continue;
                }
                if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'M') {
                    count++;
                }
            }
        }
        if (count > 0) {
            board[row][col] = (char)('0' + count);
        } else {
            board[row][col] = 'B';
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    int x = row + i;
                    int y = col + j;
                    if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'E') {
                        updateBoard(board, new int[]{x, y});
                    }
                }
            }
        }
        return board;
    }
}