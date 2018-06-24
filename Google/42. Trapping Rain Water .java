class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        // 两个数组
        // int[] leftMax = new int[height.length];
        // int[] rightMax = new int[height.length];
        // int left = 0;
        // int right = 0;
        // for (int i = 0; i < leftMax.length; i++) {
        //     left = Math.max(left, height[i]);
        //     leftMax[i] = left;
        // }
        // for (int i = leftMax.length - 1; i >= 0; i--) {
        //     right = Math.max(right, height[i]);
        //     rightMax[i] = right;
        // }
        // int res = 0;
        // for (int i = 0; i < height.length; i++) {
        //     res += (Math.min(leftMax[i], rightMax[i]) - height[i]);
        // }
        // one pass
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left <= right) {
            if (leftMax < rightMax) {
                res += Math.max(0, leftMax - height[left]);
                leftMax = Math.max(leftMax, height[left++]);
            } else {
                res += Math.max(0, rightMax - height[right]);
                rightMax = Math.max(rightMax, height[right--]);
            }
        }        
        //
        return res;
    }
} 


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