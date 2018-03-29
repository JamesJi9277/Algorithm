public class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) { return 0; }

        Set<Integer> starters = new HashSet<Integer>();
        Set<Integer> uniqs = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (uniqs.contains(nums[i] - k)) starters.add(nums[i] - k);
            if (uniqs.contains(nums[i] + k)) starters.add(nums[i]);
            uniqs.add(nums[i]);
        }

        return starters.size();
    }
}