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
        int battleships=0;
        for(int row= 0; row<board.length;++row){
            
            for(int col = 0; col<board[row].length;++col){
                boolean isInSpot=(board[row][col]=='X');
               
                if((col>0 && isInSpot&& board[row][col-1]=='X')||
                        (row>0 && isInSpot && board[row-1][col]=='X')){
                            //not a new battleship
                }
                else if(isInSpot){
                    ++battleships;
                }
               }
             }
        return battleships;
    }                
}