class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 1;
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : nums) {
            int count = 1;
            int left = i - 1;
            int right = i + 1;
            while (map.containsKey(left) && map.get(left) != 0) {
                count++;
                map.put(left, map.get(left) - 1);
                left--;
            }
            while (map.containsKey(right) && map.get(right) != 0) {
                count++;
                map.put(right, map.get(right) - 1);
                right++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}