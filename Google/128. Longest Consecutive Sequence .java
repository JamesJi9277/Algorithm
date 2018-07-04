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
        int local = 1;
        int global = 1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            if (nums[i] + 1 == nums[i + 1]) {
                local++;
            } else {
                global = Math.max(local, global);
                local = 1;
            }
        }
        return Math.max(local, global);
    }
}