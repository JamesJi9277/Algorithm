class Solution {
    String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        StringBuffer sb = new StringBuffer();
        helper(res, digits, 0, sb);
        return res;
    }
    private void helper(List<String> res, String digits, int index, StringBuffer sb) {
        if (index == digits.length()) {
            res.add(new String(sb));
            return;
        }
        String s = phone[digits.charAt(index) - '0'];
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            helper(res, digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

class Solution {
    String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
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
        }
        for (int i = index; i < digits.length(); i++) {
            String temp = phone[digits.charAt(i) - '0'];
            for (int j = 0; j < temp.length(); j++) {
                sb.append(temp.charAt(j));
                helper(res, digits, sb, i + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}