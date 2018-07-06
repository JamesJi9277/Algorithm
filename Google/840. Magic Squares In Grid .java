class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int cnt = 0;
        
        for(int i = 0; i <= grid.length - 3; i++) {
            for(int j = 0; j <= grid[0].length - 3; j++) {
                cnt += validMagicSquare(i, j, grid);
            }
        }
            
        return cnt;
    }  
    
    private int validMagicSquare(int x, int y, int[][] grid){
        int[] valid = new int[10];
        
        for(int i = x; i <= x + 2; i++) {
            for(int j = y; j <= y + 2; j++) {
                int val = grid[i][j];
                
                if(val < 10 && val > 0) {
                    
                    if (valid[val] == 1) {
                        return 0;
                    } 
                    
                    valid[val]++;
                } else {
                    return 0;
                }
            }
        }
            
        
        if (15 == grid[x][y] + grid[x][y + 1] + grid[x][y + 2]       &&    
            15 == grid[x][y] + grid[x + 1][y + 1] + grid[x + 2][y + 2]   && 
            15 == grid[x][y] + grid[x + 1][y] + grid[x + 2][y]       &&
            15 == grid[x + 2][y] + grid[x + 2][y + 1] + grid[x + 2][y + 2] &&       
            15 == grid[x][y + 2] + grid[x + 1][y + 2] + grid[x + 2][y + 2] && 
            15 == grid[x][y + 2] + grid[x + 1][y + 1] + grid[x + 2][y] ) {   

            return 1;
        }
        
        return 0;
    }
}