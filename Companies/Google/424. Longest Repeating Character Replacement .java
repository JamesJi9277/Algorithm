class Solution {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int start = 0;
        int end = 0;
        int maxLength = 0;
        int maxCount = 0;
        int[] count = new int[26];
        for (end = 0; end < s.length(); end++) {
            // 这个是当前结果中最长重复字母的个数
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            // 这个差值代表我需要替换的字母的个数
            if (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}