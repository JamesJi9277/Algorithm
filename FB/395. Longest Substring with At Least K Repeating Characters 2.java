class Solution {
    public int longestSubstring(String s, int k) {
        // read question
        // find substring that every char appear no less than k times
        return helper(s.toCharArray(), 0, s.length(), k);
    }
    
    private int helper(char[] array, int left, int right, int k) {
        if (right - left < k) {
            return 0;
        }
        int[] count = new int[26];
        for (int i = left; i < right; i++) {
            count[array[i] - 'a']++;
        }
        for (int i = left; i < right; i++) {
            if (count[array[i] - 'a'] < k) {
                int j = i + 1;
                while (j < right && count[array[j] - 'a'] < k) {
                    j++;
                }
                return Math.max(helper(array, left, i, k), helper(array, j, right, k));
            }
        }
        return right - left;
    }
}