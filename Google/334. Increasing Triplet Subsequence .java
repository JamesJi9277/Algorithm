class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i < first) {
                first = i;
            } else if (i > first && i < second) {
                second = i;
            } else if (i > second) {
                return true;
            }
        }
        return false;
    }
}
时间On空间O1