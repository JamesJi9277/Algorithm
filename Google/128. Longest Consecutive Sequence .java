class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int res = 0;
        for (int i : nums) {
            int curSmall = i;
            int curLarge = i + 1;
            int length = 0;
            while (set.contains(curSmall)) {
                length++;
                set.remove(curSmall--);
            }
            while (set.contains(curLarge)) {
                length++;
                set.remove(curLarge++);
            }
            res = Math.max(res, length);
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