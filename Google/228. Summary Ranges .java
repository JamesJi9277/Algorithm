class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int left = 0;
        while (left < nums.length) {
            int right = left;
            while (left < nums.length && right + 1 < nums.length && nums[right] + 1 == nums[right + 1]) {
                right++;
            }
            StringBuffer sb = new StringBuffer();
            sb.append(nums[left] + "");
            if (right != left) {
                sb.append("->");
                sb.append(nums[right] + "");
            }
            res.add(sb.toString());
            left = ++right;
        }
        return res;
    }
}