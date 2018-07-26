class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        int minLeft = 0;
        int minRight = 0;
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    count++;
                }
            }
            right++;
            while (left < right && count == map.size()) {
                if (right - left < minLen) {
                    minRight = right;
                    minLeft = left;
                    minLen = minRight - minLeft;
                }
                char lc = s.charAt(left);
                if (map.containsKey(lc)) {
                    if (map.get(lc) == 0) {
                        count--;
                    }
                    map.put(lc, map.get(lc) + 1);
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minRight);
    }
}