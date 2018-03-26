// add 1 on each number is same as substract 1 on each number
class Solution {
    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i : nums) {
            min = Math.min(min, i);
        }
        for (int i : nums) {
            res += (i - min);
        }
        return res;
    }
}