// On, On
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int length = height.length;
        int[] left = new int[length];
        int[] right = new int[length];
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                left[i] = height[i];
            } else {
                left[i] = Math.max(left[i - 1], height[i]);
            }
        }
        for (int i = length - 1; i >= 0; i--) {
            if (i == length - 1) {
                right[i] = height[i];
            } else {
                right[i] = Math.max(right[i + 1], height[i]);
            }
        }
        int res = 0;
        for (int i = 0; i < length; i++) {
            res += (Math.min(left[i], right[i]) - height[i]);
        }
        return res;
    }
}

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int leftMax = height[left];
        int right = height.length - 1;
        int rightMax = height[right];
        int sum = 0;
        while (left <= right) {
            if (leftMax < rightMax) {
                sum += (Math.max(leftMax - height[left], 0));
                leftMax = Math.max(leftMax, height[left++]);
            } else {
                sum += (Math.max(rightMax - height[right], 0));
                rightMax = Math.max(rightMax, height[right--]);
            }
        }
        return sum;
    }
}