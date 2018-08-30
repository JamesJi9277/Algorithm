class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        HashMap<Character, Integer> map = constructMap(t);
        int left = 0;
        int right = 0;
        int minLeft = 0;
        int minRight = 0;
        int min = Integer.MAX_VALUE;
        int match = 0;
        while (right < s.length()) {
            char rc = s.charAt(right);
            if (map.containsKey(rc)) {
                map.put(rc, map.get(rc) - 1);
                if (map.get(rc) == 0) {
                    match++;
                }
            }
            right++;
            while (left < right && match == map.size()) {
                if (right - left < min) {
                    minLeft = left;
                    minRight = right;
                    min = minRight - minLeft;
                }
                char lc = s.charAt(left);
                if (map.containsKey(lc)) {
                    if (map.get(lc) == 0) {
                        match--;
                    }
                    map.put(lc, map.get(lc) + 1);
                }
                left++;
            }
        }
        return min == Integer.MIN_VALUE ? "" : s.substring(minLeft, minRight);
    }
    private HashMap<Character, Integer> constructMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.putIfAbsent(s.charAt(i), 0);
            map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }
        return map;
    }
}