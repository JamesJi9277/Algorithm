class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int[] height = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    height[j] = 0;
                } else {
                    height[j]++;
                }
            }
            max = Math.max(max, helper1(height));
        }
        return max;
    }
    private int helper(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = -1;
        right[height.length - 1] = height.length;
        int max = 0;
        for (int i = 1; i < height.length; i++) {
            int p = i - 1;
            while (p >= 0 && height[p] >= height[i]) {
                p = left[p];
            }
            left[i] = p;
        }
        for (int i = right.length - 2; i >= 0; i--) {
            int q = i + 1;
            while (q < height.length && height[q] >= height[i]) {
                q = right[q];
            }
            right[i] = q;
        }
        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, (right[i] - left[i] - 1) * height[i]);
        }
        return max;
    }
    private int helper1(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            int left = findLeft(height, i);
            int right = findRight(height, i);
            max = Math.max(max, (right - left - 1) * height[i]);
        }
        return max;
    }
    private int findLeft(int[] height, int index) {
        int val = height[index];
        while (index >= 0 && height[index] >= val) {
            index--;
        }
        return index;
    }
    private int findRight(int[] height, int index) {
        int val = height[index];
        while (index < height.length && height[index] >= val) {
            index++;
        }
        return index;
    }
}