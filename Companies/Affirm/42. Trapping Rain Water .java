class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            if (i == 0) {
                left[i] = height[i];
            } else {
                left[i] = Math.max(left[i - 1], height[i]);
            }
        }
        for (int i = height.length - 1; i >= 0; i--) {
            if (i == height.length - 1) {
                right[i] = height[i];
            } else {
                right[i] = Math.max(right[i + 1], height[i]);
            }
        }
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            sum += (Math.min(left[i], right[i]) - height[i]);
        }
        return sum;
    }
}

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int sum = 0;
        while (left <= right) {
            if (leftMax < rightMax) {
                sum += Math.max(0, leftMax - height[left]);
                leftMax = Math.max(leftMax, height[left++]);
            } else {
                sum += Math.max(0, rightMax - height[right]);
                rightMax = Math.max(rightMax, height[right--]);
            }
        }
        return sum;
    }
}