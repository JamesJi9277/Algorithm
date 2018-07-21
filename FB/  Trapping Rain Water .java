class Solution {
    public int trap(int[] height) {
        // On On
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int leftMax = 0;
        int rightMax = 0;
        for (int i = 0; i < height.length; i++) {
            leftMax = Math.max(leftMax, height[i]);
            left[i] = leftMax;
        }
        for (int i = height.length - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i]);
            right[i] = rightMax;
        }
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            sum += (Math.min(left[i], right[i]) - height[i]);
        }
        return sum;
    }
}