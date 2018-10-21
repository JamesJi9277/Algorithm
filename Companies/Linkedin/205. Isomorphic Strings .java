class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1) && map.get(c1) != c2) {
                return false;
            }
            if (map.containsValue(c2) && !map.containsKey(c1)) {
                return false;
            }
            map.put(c1, c2);
        }
        return true;
    }
}