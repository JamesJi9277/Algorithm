class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k < 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j - i <= k && j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }
}


class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k < 0) {
            return false;
        }
        TreeSet<Integer> set = new TreeSet<>();
        // ceiling : Returns the least element in this set greater than or equal to the given element, or null if there is no such element 最小的大的
        // floor : Returns the greatest element in this set less than or equal to the given element, or null if there is no such element.最大的小的
        for (int i = 0; i < nums.length; i++) {
            Integer floor = set.floor(nums[i] + t);
            Integer ceiling = set.ceiling(nums[i] - t);
            if ((floor != null && floor >= nums[i]) || (ceiling != null && ceiling <= nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}