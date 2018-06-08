class Solution {
    /**X1/X2/X3/X4/X5...
 * we need to maximize the numerator, and minimize the denominator;
 * so the answer will always be X1/(X2/X3/X4/X5...);
 */
    public String optimalDivision(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        if (nums.length == 1) return nums[0] + "";
        if (nums.length == 2) return nums[0] + "/" + nums[1];
        StringBuilder s = new StringBuilder();
        s.append(nums[0] + "/(" + nums[1]);
        for (int i = 2; i < nums.length; i++) {
            s.append("/");
            s.append(nums[i]);
        }
        s.append(")");
        return s.toString();   
    }
}