class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (helper(word, pattern)) {
                res.add(word);
            }
        }
        return res;
    }
    private boolean helper(String s1, String s2) {
        Map<Character, Character> map = new HashMap<>();
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
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