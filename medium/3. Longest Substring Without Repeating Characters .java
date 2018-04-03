时间On2，空间On
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        while (left < s.length()) {
            int right = left;
            while (right < s.length()) {
                char c = s.charAt(right);
                if (!set.contains(c)) {
                    set.add(c);
                    max = Math.max(max, set.size());
                    right++;
                } else {
                    set.clear();
                    break;
                }
            }
            left++;
        }
        return max;
    }
}

时间On空间On
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (!map.containsKey(c)) {
                map.put(c, right);
            } else {
                if (map.get(c) < left) {
                    map.put(c, right);
                } else {
                    max = Math.max(max, right - left);
                    left = map.get(c) + 1;
                    map.put(c, right);
                }
            }
        }
        max = Math.max(max, right - left);
        return max;
    }
}