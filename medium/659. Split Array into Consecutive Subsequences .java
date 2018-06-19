class Solution {
    public boolean isPossible(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : nums) {
            if (map.get(i) == 0) {
                continue;
            } else if (map1.getOrDefault(i, 0) > 0) {
                map1.put(i, map1.get(i) - 1);
                map1.put(i + 1, map1.getOrDefault(i + 1, 0) + 1);
            } else if (map.getOrDefault(i + 1, 0) > 0 && map.getOrDefault(i + 2, 0) > 0) {
                map.put(i + 1, map.get(i + 1) - 1);
                map.put(i + 2, map.get(i + 2) - 1);
                map1.put(i + 3, map1.getOrDefault(i + 3, 0) + 1);
            } else {
                return false;
            }
            map.put(i, map.get(i) - 1);
        }
        return true;
    }
}

https://leetcode.com/problems/split-array-into-consecutive-subsequences/discuss/106496/java-on-time-on-space


// second write, bug free
class Solution {
    public boolean isPossible(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : nums) {
            if (map.get(i) == 0) {
                continue;
            } else if (map1.getOrDefault(i, 0) > 0) {
                map1.put(i, map1.get(i) - 1);
                map1.put(i + 1, map1.getOrDefault(i + 1, 0) + 1);
            } else if (map.getOrDefault(i + 1, 0) > 0 && map.getOrDefault(i + 2, 0) > 0) {
                map.put(i + 1, map.get(i + 1) - 1);
                map.put(i + 2, map.get(i + 2) - 1);
                map1.put(i + 3, map1.getOrDefault(i + 3, 0) + 1);
            } else {
                return false;
            }
            map.put(i, map.getOrDefault(i, 0) - 1);
        }
        return true;
    }
}