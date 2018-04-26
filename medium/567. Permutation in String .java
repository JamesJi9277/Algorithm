//暴力
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return false;
        }
        s1 = sort(s1);
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            String temp = s2.substring(i, i + s1.length());
            temp = sort(temp);
            if (temp.equals(s1)) {
                return true;
            }
        }
        return false;
    }
    private String sort(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }
}
// 穷举 暴力
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return false;
        }
        List<String> res = helper(s1);
        for (String s : res) {
            if (s2.contains(s)) {
                return true;
            }
        }
        return false;
    }
    private List<String> helper(String s) {
        char[] array = s.toCharArray();
        List<String> res = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        dfs(res, array, sb);
        return res;
    }
    private void dfs(List<String> res, char[] array, StringBuffer sb) {
        if (sb.length() == array.length) {
            res.add(new String(sb));
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (sb.indexOf(array[i] + "") != -1) {
                continue;
            }
            sb.append(array[i]);
            dfs(res, array, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}