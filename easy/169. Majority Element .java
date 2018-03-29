// 时间On
// 空间On
class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums) {
            int count = map.getOrDefault(i, 0);
            if (count + 1 > length / 2) {
                return i;
            } else {
                map.put(i, count + 1);
            }
        }
        return 0;
    }
}
class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == result) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    result = nums[i];
                    count = 1;
                }
            }
        }
        return result;
    }
}