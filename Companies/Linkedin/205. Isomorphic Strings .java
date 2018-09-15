class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1) && map.get(c1) != c2) {
                return false;
            }
            if (!map.containsKey(c1) && map.containsValue(c2)) {
                return false;
            }
            map.put(c1, c2);
        }
        return true;
    }
}