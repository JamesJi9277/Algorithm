//利用n queen的原始思想
// 只要找到满足条件的就继将结果加一
class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        if (n < 0) {
            return 0;
        }
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        helper(board, 0);
        return count;
    }
    private void helper(char[][] board, int colIndex) {
        if (colIndex == board[0].length) {
            count++;
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (valid(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                helper(board, colIndex + 1);
                board[i][colIndex] = '.';
            }
        }
    }
    private boolean valid(char[][] board, int x, int y) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 'Q') {
                    if (x == i || x + y == i + j || x + j == i + y) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}


public class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        boolean[] rows = new boolean[n];
        boolean[] d1 = new boolean[2 * n];
        boolean[] d2 = new boolean[2 * n];
        helper(0, rows, d1, d2, n);
        return count;
    }
    private void helper(int col, boolean[] rows, boolean[] d1, boolean[] d2, int n) {
        if (col == n) {
            count++;
        }
        for (int row = 0; row < n; row++) {
            int id1 = row + col; // 左下
            int id2 = row - col + n; // 左上
            if (rows[row] || d1[id1] || d2[id2]) {
                continue;
            }
            rows[row] = true; d1[id1] = true; d2[id2] = true;
            helper(col + 1, rows, d1, d2, n);
            rows[row] = false; d1[id1] = false; d2[id2] = false;
        }
    }
}


/**
 * don't need to actually place the queen,
 * instead, for each row, try to place without violation on
 * col/ diagonal1/ diagnol2.
 * trick: to detect whether 2 positions sit on the same diagnol:
 * if delta(col, row) equals, same diagnol1;
 * if sum(col, row) equals, same diagnal2.
 */
private final Set<Integer> occupiedCols = new HashSet<Integer>();
private final Set<Integer> occupiedDiag1s = new HashSet<Integer>();
private final Set<Integer> occupiedDiag2s = new HashSet<Integer>();
public int totalNQueens(int n) {
    return totalNQueensHelper(0, 0, n);
}

private int totalNQueensHelper(int row, int count, int n) {
    for (int col = 0; col < n; col++) {
        if (occupiedCols.contains(col))
            continue;
        int diag1 = row - col;
        if (occupiedDiag1s.contains(diag1))
            continue;
        int diag2 = row + col;
        if (occupiedDiag2s.contains(diag2))
            continue;
        // we can now place a queen here
        if (row == n-1)
            count++;
        else {
            occupiedCols.add(col);
            occupiedDiag1s.add(diag1);
            occupiedDiag2s.add(diag2);
            count = totalNQueensHelper(row+1, count, n);
            // recover
            occupiedCols.remove(col);
            occupiedDiag1s.remove(diag1);
            occupiedDiag2s.remove(diag2);
        }
    }
    
    return count;
}



https://leetcode.com/problems/n-queens-ii/discuss/20058/Accepted-Java-Solution