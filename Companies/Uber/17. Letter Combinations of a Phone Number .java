class Solution {
    private static final String[] numbers = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        StringBuffer sb = new StringBuffer();
        helper(res, digits, sb, 0);
        return res;
    }
    private void helper(List<String> res, String digits, StringBuffer sb, int index) {
        if (sb.length() == digits.length()) {
            res.add(new String(sb));
            return;
        }
        for (int i = index; i < digits.length(); i++) {
            String temp = numbers[digits.charAt(i) - '0'];
            for (int j = 0; j < temp.length(); j++) {
                sb.append(temp.charAt(j));
                helper(res, digits, sb, i + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}