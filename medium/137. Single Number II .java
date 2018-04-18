class Solution {
    public int singleNumber(int[] nums) {
        // 传统的做法是hashmap
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        //这个调用要牢记于心
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }
}


class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] bit = new int[32];
        int res = 0;
        for (int i = 0; i < 32; i++) {
            for (int j : nums) {
                // this is get bit
                bit[31 - i] += ((j >> i) & 1);
                bit[31 - i] %= 3;
            }
            // this is set bit
            res |= (bit[31 - i] << i);
        }
        return res;
    }
}