class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) {
            return res;
        }
        List<String> temp = new ArrayList<String>();
        helper(s, res, temp, 0);
        return res;
    }
    private void helper(String s, List<List<String>> res, List<String> temp, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<String>(temp));
            return;
        }
        for (int i = index + 1; i <= s.length(); i++) {
            String pre = s.substring(index, i);
            if (!isPalindrome(pre)) {
                continue;
            }
            temp.add(pre);
            helper(s, res, temp, i);
            temp.remove(temp.size() - 1);
        }
    }
    private boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}