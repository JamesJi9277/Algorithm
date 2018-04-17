// class Solution {
//     public int findMin(int[] nums) {
//         int res = Integer.MAX_VALUE;
//         for (int i : nums) {
//             res = Math.min(res, i);
//         }
//         return res;
//     }
// }
class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // 只需要移动对于自己有利的
            if (nums[end] > nums[mid]) {
                end = mid;
            }  else {
                start = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
}