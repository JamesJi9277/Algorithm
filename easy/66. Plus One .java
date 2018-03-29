public class Solution {
    public int[] plusOne(int[] digits) {
        // 需要考虑到移位和溢出的情况
        // 所以将原数组转换为arraylist来做
        List<Integer> res = new ArrayList<Integer>();
        if(digits == null || digits.length == 0) {
            res.add(1);
            return toInt(res);
        }
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--) {
            int digit = (carry + digits[i]) % 10;
            carry = (carry + digits[i]) / 10;
            res.add(digit);
        }
        if(carry == 1) {
            res.add(1);
        }
        return toInt(res);
    }
    private int[] toInt(List<Integer> nums) {
        int[] res = new int[nums.size()];
        for(int i = 0; i < nums.size(); i++) {
            res[i] = nums.get(nums.size() - 1 - i);
        }
        return res;
    }
}