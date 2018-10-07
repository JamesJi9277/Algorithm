class Solution {
    public boolean isPossible(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> need = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : nums) {
            if (map.get(i) == 0) {
                continue;
            } else if (need.getOrDefault(i, 0) > 0) {
                need.put(i, need.get(i) - 1);
                need.put(i + 1, need.getOrDefault(i + 1, 0) + 1);
            } else if (map.getOrDefault(i + 1, 0) > 0 && map.getOrDefault(i + 2, 0) > 0) {
                map.put(i + 1, map.get(i + 1) - 1);
                map.put(i + 2, map.get(i + 2) - 1);
                need.put(i + 3, need.getOrDefault(i + 3, 0) + 1);
            } else {
                return false;
            }
            map.put(i, map.getOrDefault(i, 0) - 1);
        }
        return true;
    }
}