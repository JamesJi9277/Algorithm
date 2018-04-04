class Solution {
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        helper(digits, res, "", 0);
        return res;
    }
    private void helper(String digits, List<String> res, String prefix, int index) {
        if (index == digits.length()) {
            res.add(prefix);
            return;
        }
        String s = KEYS[digits.charAt(index) - '0'];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            helper(digits, res, prefix + c, index + 1);
        }
    }
}