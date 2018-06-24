class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        int res = 0;
        for (int i : nums) {
            set.add(i);
        }
        for (int i : nums) {
            int asc = 0;
            int desc = 0;
            while (set.contains(i + asc)) {
                asc++;
            }
            while (set.contains(i - desc)) {
                desc++;
            }
            res = Math.max(res, asc + desc - 1);
        }
        return res;
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 1;
        int local = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                continue;
            }
            if (nums[i] - nums[i - 1] != 1) {
                max = Math.max(max, local);
                local = 1;
            } else {
                local++;
            }
        }
        max = Math.max(max, local);
        return max;
    }
}