class Solution {
    public int lengthOfLongestSubstring(String s) {
        // longest substring without repeating characters
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int prev = -1;
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
            // if not get max, think about abba
                prev = Math.max(prev, map.get(c));
            }
            map.put(c, i);
            max = Math.max(max, i - prev);
        }
        return max;
    }
}