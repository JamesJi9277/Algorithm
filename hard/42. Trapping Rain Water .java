class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[0];
        int rightMax = height[right];
        int res = 0;
        while (left <= right) {
            if (leftMax < rightMax) {
                res += Math.max(leftMax - height[left], 0);
                leftMax = Math.max(leftMax, height[left++]);
            } else {
                res += Math.max(rightMax - height[right], 0);
                rightMax = Math.max(rightMax, height[right--]);
            }
        }
        return res;
    }
}
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int max = height[0];
        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, height[i]);
            leftMax[i] = max;
        }
        max = height[height.length - 1];
        for (int i = height.length - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            rightMax[i] = max;
        }
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            res += (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        return res;
    }
}