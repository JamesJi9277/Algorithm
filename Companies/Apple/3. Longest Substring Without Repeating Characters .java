class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int prev = -1;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                prev = Math.max(prev, map.get(s.charAt(i)));
            }
            res = Math.max(res, i - prev);
            map.put(s.charAt(i), i);
        }
        return res;
    }
}