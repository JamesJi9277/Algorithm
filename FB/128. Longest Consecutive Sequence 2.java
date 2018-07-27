class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int max = 1;
        for (int i : nums) {
            int count = 0;
            int asc = i;
            int desc = i - 1;
            while (set.contains(asc)) {
                set.remove(asc++);
                count++;
            }
            while (set.contains(desc)) {
                set.remove(desc--);
                count++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}