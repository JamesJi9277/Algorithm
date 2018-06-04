// naive and TLE
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        helper(subsets, res, nums, 0);
        for (List<Integer> temp : subsets) {
            if (isValid(temp) && temp.size() >= res.size()) {
                res = temp;
            }
        }
        return res;
    }
    private boolean isValid(List<Integer> res) {
        for (int i : res) {
            for (int j : res) {
                if (!(i % j == 0 || j % i == 0)) {
                    return false;
                }
            }
        }
        return true;
    }
    private void helper(List<List<Integer>> res, List<Integer> temp, int[] nums, int index) {
        res.add(new ArrayList<Integer>(temp));
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            helper(res, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}



class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int[] parents = new int[dp.length];
        Arrays.fill(parents, -1);
        int largest = 0;
        int largestAt = 0;
        for (int j = 0; j < nums.length; j++) {
            for (int i = 0; i < j; i++) {
                if (nums[j] % nums[i] == 0 && dp[i] + 1 > dp[j]) {
                    dp[j] = dp[i] + 1;
                    parents[j] = i;
                }
            }
            if (dp[j] > largest) {
                largest = dp[j];
                largestAt = j;
            }
        }
        for (int i = 0; i < largest; i++) {
            res.add(0, nums[largestAt]);
            largestAt = parents[largestAt];
        }
        return res;
    }
}