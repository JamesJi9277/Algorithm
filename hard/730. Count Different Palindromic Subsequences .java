class Solution {
    public int countPalindromicSubsequences(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        List<String> res = helper(s);
        return res.size() % 1000000007;
    }
    private List<String> helper(String s) {
        List<String> res = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        helper1(s, res, sb, 0);
        return res;
    }
    private void helper1(String s, List<String> res, StringBuffer sb, int index) {
        for (int i = index; i < s.length(); i++) {
            sb.append(s.charAt(i));
            String temp = new String(sb);
            if (!res.contains(temp) && isPalindrome(temp)) {
                res.add(new String(sb));
            }
            helper1(s, res, sb, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        for (int i = 0; left + i < right - i; i++) {
            if (s.charAt(left + i) != s.charAt(right - i)) {
                return false;
            }
        }
        return true;
    }
}