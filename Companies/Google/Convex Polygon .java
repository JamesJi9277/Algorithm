public class Solution {
    /**
     * @param point: a list of two-tuples
     * @return: a boolean, denote whether the polygon is convex
     */
    public boolean isConvex(int[][] point) {
        // write your code here
        if (point == null || point.length == 0 || point[0].length == 0) {
            return false;
        }
        boolean isNeg = false;
        boolean isPos = false;
        for (int i = 2; i < point.length + 2; i++) {
            int[] p1 = point[(i - 2) % point.length];
            int[] p2 = point[(i - 1) % point.length];
            int[] p3 = point[i % point.length];
            if (crossProduct(p1, p2, p3) > 0) {
                isPos = true;
            } else if (crossProduct(p1, p2, p3) < 0) {
                isNeg = true;
            }
        }
        return isPos ^ isNeg;
    }
    private int crossProduct(int[] p1, int[] p2, int[] p3) {
        int ax = p2[0] - p1[0];
        int ay = p2[1] - p1[1];
        int bx = p3[0] - p2[0];
        int by = p3[1] - p2[1];
        int cp = ax * by - ay * bx;
        if (cp > 0) {
            return 1;
        } else if (cp < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}