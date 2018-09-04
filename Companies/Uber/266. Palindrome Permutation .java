class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        boolean one = false;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                if (one) {
                    return false;
                }
                one = true;
            }
        }
        return true;
    }
}