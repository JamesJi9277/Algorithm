class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int index = binarySearch(arr, x);
        int left = index;
        int right = index;
        while (k > 1) {
            if (left == 0) {
                right++;
            } else if (right == arr.length - 1) {
                left--;
            } else if (Math.abs(arr[left - 1] - x) <= Math.abs(arr[right + 1] - x)) {
                left--;
            } else {
                right++;
            }
            k--;
        }
        for (int i = left; i <= right; i++) {
            res.add(arr[i]);
        }
        return res;
    }
    private int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return start;
    }
}