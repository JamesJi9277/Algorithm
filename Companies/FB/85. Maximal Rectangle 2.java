class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[] height = new int[matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    height[j] = 0;
                } else {
                    height[j]++;
                }
            }
            max = Math.max(max, helper(height));
        }
        return max;
    }
    public int helper(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        left[0] = -1;
        right[right.length - 1] = heights.length;
        int max = 0;
        for (int i = 1; i < left.length; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i]) {
                p = left[p];
            }
            left[i] = p;
        }
        for (int i = right.length - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < right.length && heights[p] >= heights[i]) {
                p = right[p];
            }
            right[i] = p;
        }
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, (right[i] - left[i] - 1) * heights[i]);
        }
        return max;
    }
}