class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int start = 0;
        int runner = 0;
        while (runner < nums.length) {
            StringBuffer sb = new StringBuffer();
            sb.append(nums[start] + "");
            while (runner + 1 < nums.length && nums[runner] + 1 == nums[runner + 1]) {
                runner++;
            }
            if (runner != start) {
                sb.append("->");
                sb.append(nums[runner] + "");
            }
            res.add(sb.toString());
            runner++;
            start = runner;
        }
        return res;
    }
}