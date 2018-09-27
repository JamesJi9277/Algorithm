class Solution {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        // find first height which is lower than current, and then width is the target width
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = -1;
        right[height.length - 1] = height.length;
        for (int i = 1; i < height.length; i++) {
            int p = i - 1;
            while (p >= 0 && height[p] >= height[i]) {
                p = left[p];
            }
            left[i] = p;
        }
        for (int i = right.length - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < right.length && height[p] >= height[i]) {
                p = right[p];
            }
            right[i] = p; 
        }
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, (right[i] - left[i] - 1) * height[i]);
        }
        return max;
    }
}