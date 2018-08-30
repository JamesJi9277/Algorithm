class Solution {
    private static final String[] phone = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        StringBuffer sb = new StringBuffer();
        helper(digits, sb, 0, res);
        return res;
    }
    private void helper(String digits, StringBuffer sb, int index, List<String> res) {
        if (sb.length() == digits.length()) {
            res.add(new String(sb));
            return;
        }
        for (int i = index; i < digits.length(); i++) {
            String digit = phone[digits.charAt(i) - '0'];
            for (int j = 0; j < digit.length(); j++) {
                sb.append(digit.charAt(j));
                helper(digits, sb, i + 1, res);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}