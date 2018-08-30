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
        int left = 0;
        int right = 0;
        int minLeft = 0;
        int minRight = 0;
        int minLen = Integer.MAX_VALUE;
        int count = 0;
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
                    minLen = right - left;
                    minRight = right;
                    minLeft = left;
                }
                char c1 = s.charAt(left);
                if (map.containsKey(c1)) {
                    if (map.get(c1) == 0) {
                        count--;
                    }
                    map.put(c1, map.get(c1) + 1);
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minRight);
    }
}