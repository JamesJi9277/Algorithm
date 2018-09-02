class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        List<String> temp = new ArrayList<>();
        helper(res, temp, s, 0);
        return res;
    }
    private void helper(List<List<String>> res, List<String> temp, String s, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalin(s.substring(index, i + 1))) {
                temp.add(s.substring(index, i + 1));
                helper(res, temp, s, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
    private boolean isPalin(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}