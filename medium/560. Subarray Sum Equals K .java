// brute force On3
class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (getSum(nums, i, j) == k) {
                    count++;
                }
            }
        }
        return count;
    }
    private int getSum(int[] nums, int i, int j) {
        int res = 0;
        for (int k = i; k <= j; k++) {
            res += nums[k];
        }
        return res;
    }
}
// On2
class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int res = 0;
        int count = 0;
        while (left < nums.length) {
            while (right < nums.length) {
                res += nums[right];
                if (res == k) {
                    count++;
                }
                right++;
            }
            left++;
            right = left;
            res = 0;
        }
        return count;
    }
}


On, On
前缀和加上hashmap存frequency
class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}