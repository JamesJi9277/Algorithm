class Solution {
    public int numDecodings(String s) {
        //动态规划
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] res = new int[s.length() + 1];
        res[0] = 1;
        res[1] = (isValid(s.substring(0, 1)) == true ? 1 : 0);
        for (int i = 2; i <= s.length(); i++) {
            if (isValid(s.substring(i - 1, i))) {
                res[i] += res[i - 1];
            }
            if (isValid(s.substring(i - 2, i))) {
                res[i] += res[i - 2];
            }
        }
        return res[s.length()];
    }
    private boolean isValid(String s) {
        if(s.charAt(0) == '0') {
            return false;
        }
        int temp = Integer.parseInt(s);
        if(!(temp > 0 && temp <= 26)) {
            return false;
        }
        return true;
    }
}