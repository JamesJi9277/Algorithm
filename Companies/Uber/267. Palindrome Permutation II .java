class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        List<String> res1 = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        res = getPermu(s);
        for (String s1 : res) {
            if (isPalin(s1) && !res1.contains(s1)) {
                res1.add(s1);
            }
        }
        return res1;
    }
    private List<String> getPermu(String s) {
        List<String> res = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        boolean[] visited = new boolean[s.length()];
        helper(res, s, sb, visited);
        return res;
    }
    private void helper(List<String> res, String s, StringBuffer sb, boolean[] visited) {
        if (sb.length() == s.length()) {
            res.add(new String(sb));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            sb.append(s.charAt(i));
            helper(res, s, sb, visited);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
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