class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        for (int i = 0; i <= nums.length - 4; i++) {
            find3Sum(nums, target, i, set, result);
        }
        return result;
    }
    private void find3Sum(int[] nums, int target, int leftBound, HashSet<List<Integer>> set, List<List<Integer>> result) {
        for (int i = leftBound + 1; i <= nums.length - 3; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[leftBound] + nums[i] + nums[left] + nums[right] == target) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[leftBound]);
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    if (!set.contains(temp)) {
                        result.add(temp);
                        set.add(temp);
                    }
                    left++;
                    right--;
                } else if (nums[leftBound] + nums[i] + nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
    }
}