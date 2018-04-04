class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i; j < height.length; j++) {
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return max;
    }
}

class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int base = right - left;
            max = Math.max(max, h * base);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
}