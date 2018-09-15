class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            return null;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int minLeft = 0;
        int minRight = 0;
        int min = Integer.MAX_VALUE;
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
            while (count == map.size()) {
                if (right - left < min) {
                    minLeft = left;
                    minRight = right;
                    min = right - left;
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
        return min == Integer.MAX_VALUE ? "" : s.substring(minLeft, minRight);
    }
}