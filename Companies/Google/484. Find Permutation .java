class Solution {
    public int[] findPermutation(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int[] res = new int[s.length() + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'D') {
                int start = i;
                while (i + 1 < s.length() && s.charAt(i + 1) == 'D') {
                    i++;
                }
                reverse(res, start, i + 1);
            }
        }
        return res;
    }
    private void reverse(int[] nums, int start, int end) {
        for (int i = 0; start + i < end - i; i++) {
            int temp = nums[start + i];
            nums[start + i] = nums[end - i];
            nums[end - i] = temp;
        }
    }
}