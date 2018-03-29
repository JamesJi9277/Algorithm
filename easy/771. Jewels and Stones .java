class Solution {
    public int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0 || S == null || S.length() == 0) {
            return 0;
        }
        int count = 0;
        HashSet<Character> set = constructSet(J);
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (set.contains(c)) {
                count++;
            }
        }
        return count;
    }
    private HashSet<Character> constructSet(String s) {
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
            }
        }
        return set;
    }
}