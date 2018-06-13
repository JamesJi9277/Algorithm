https://leetcode.com/problems/largest-plus-sign/discuss/133386/Clear-Java-Solution-with-O(N2)-complexity-and-space


class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[] dr = {-1, 1, 0,  0 };
        int[] dc = { 0, 0, 1, -1 };
        boolean[][] map = new boolean[N][N];
        for(int i = 0; i < mines.length; ++i) 
            map[mines[i][0]][mines[i][1]] = true;
        int ans = 0;
        for(int r = 0; r < N; ++r) {
            for(int c = 0; c < N; ++c) {
                if(map[r][c]) continue;
                int cur = 0;
                whileloop:
                while(true) {
                   for(int i = 0; i < dr.length; ++i) {
                        int nr = r + dr[i] + dr[i]*cur, nc = c + dc[i] + dc[i]*cur;
                        if(nr >= N || nr < 0 || nc >= N || nc < 0 || map[nr][nc]) {
                            break whileloop;
                        }
                    }
                    ++cur;
                }
                if(ans < cur + 1) ans = cur + 1;
            }
        }
        return ans;
    }
    
}