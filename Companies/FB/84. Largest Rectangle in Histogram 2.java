// for each bar, find leftmost and rightmost bar which height are no less than it
// then caculate the area and get max
// time On2 space O1
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = findLeft(heights, i);
            int right = findRight(heights, i);
            max = Math.max(max, (right - left + 1) * heights[i]);
        }
        return max;
    }
    private int findLeft(int[] heights, int index) {
        int pivot = heights[index];
        int i = index;
        while (i >= 0 && heights[i] >= pivot) {
            i--;
        }
        return i + 1;
    }
    private int findRight(int[] heights, int index) {
        int pivot = heights[index];
        int i = index;
        while (i < heights.length && heights[i] >= pivot) {
            i++;
        }
        return i - 1;
    }
}


class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        left[0] = -1;
        for (int i = 1; i < left.length; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i]) {
                p = left[p];
            }
            left[i] = p;
        }
        right[right.length - 1] = heights.length;
        for (int i = right.length - 2; i >= 0; i--) {
            int p = i + 1;
            while (p < right.length && heights[p] >= heights[i]) {
                p = right[p];
            }
            right[i] = p;
        }
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, (right[i] - left[i] - 1) * heights[i]);
        }
        return max;
    }
}