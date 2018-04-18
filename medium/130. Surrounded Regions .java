class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        //对于这种四面寻找有方向图题目
        //需要一个东西来判定已经走过
        int[][] used = new int[board.length][board[0].length];
        for (int i = 0; i < board[0].length; i++) {
            fill(board, used, 0, i);
            fill(board, used, board.length - 1, i);
        }
        for (int i = 0; i < board.length; i++) {
            fill(board, used, i, 0);
            fill(board, used, i, board[0].length - 1);
        }
        for(int i = 0; i < board.length; i++) {
        	for(int j = 0; j < board[0].length; j++) {
        		if(board[i][j] == 'O') {
        			board[i][j] = 'X';
        		}
        		else if(board[i][j] == '&') {
        			board[i][j] = 'O';
        		}
        	}
        }
    }
    private void fill(char[][] board, int[][] used, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || used[i][j] == 1 || board[i][j] == 'X') {
            return;
        }
        board[i][j] = '&';
        used[i][j] = 1;
        fill(board, used, i - 1, j);
        fill(board, used, i + 1, j);
        fill(board, used, i, j + 1);
        fill(board, used, i, j - 1);
    }
}