// 扫描线算法
class Solution {
    public int countCornerRectangles(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = i + 1; j < grid.length; j++) {
                int counter = 0;
                for (int k = 0; k < grid[0].length; k++) {
                    if (grid[i][k] == 1 && grid[j][k] == 1) counter++;
                }
                if (counter > 0) ans += counter * (counter - 1) / 2;
            }
        }
        return ans;
    }
}
class Solution {
    public int countCornerRectangles(int[][] grid) {
        if(grid.length < 2 || grid[0].length < 2) return 0;
        int[][] count = new int[grid[0].length][grid[0].length];
        int ans = 0;
        for(int row = 0; row < grid.length; ++row){
            for(int i = 0; i < grid[0].length - 1; ++i){
                if(grid[row][i] == 1){
                    for(int j = i+1; j < grid[0].length; ++j){
                        if(grid[row][j] == 1){
                            ans += count[i][j];
                            count[i][j]++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}

class Solution {
    public int countCornerRectangles(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length - 1; i++) {
            for (int j = 0; j < grid[0].length - 1; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                for (int m = i + 1; m < grid.length; m++) {
                    for (int n = j + 1; n < grid[0].length; n++) {
                        if (grid[m][n] == 0) {
                            continue;
                        }
                        res += grid[i][n] * grid[m][j];
                    }
                }
            }
        }
        return res;
    }
}