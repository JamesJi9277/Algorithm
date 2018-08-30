class Solution {
    public int minPatches(int[] nums, int n) {
        int count = 0;
        int i = 0;
        for (long covered = 0; covered < n;) {
            if ((i < nums.length && nums[i] > covered + 1) || i >= nums.length) {
                covered += (covered + 1);
                count++;
            } else {
                covered += nums[i];
                i++;
            }
        }
        return count;
    }
}

long miss = 1, added = 0, i = 0;
    while (miss <= n) {
        if (i < nums.size() && nums[i] <= miss) {
            miss += nums[i++];
        } else {
            miss += miss;
            added++;
        }
    }
    return added;