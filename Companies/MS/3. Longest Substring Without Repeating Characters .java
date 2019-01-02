class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int prev = -1;
        int max = 1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                prev = Math.max(prev, map.get(c));
            }
            map.put(c, i);
            max = Math.max(max, i - prev);
        }
        return max;
    }
}