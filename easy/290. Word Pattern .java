class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        String[] strs = str.split(" ");
        if (strs.length != pattern.length()) {
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if ((map.containsKey(c) && !map.get(c).equals(strs[i])) || (!map.containsKey(c) && map.containsValue(strs[i]))) {
                return false;
            } else {
                map.put(c, strs[i]);
            }
        }
        return true;
    }
}