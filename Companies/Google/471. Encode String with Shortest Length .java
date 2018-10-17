class Solution {
    public String encode(String s) {
        String[][] dp = new String[s.length()][s.length()];
        for (int len = 0; len < s.length(); len++) {
            for (int i = 0; i < s.length() - len; i++) {
                int j = i + len;
                String sub = s.substring(i, j + 1);
                // if less than 5, won't help
                if (sub.length() < 5) {
                    dp[i][j] = sub;
                } else {
                    dp[i][j] = sub;
                    for (int k = i; k < j; k++) {
                        if (dp[i][k].length() + dp[k + 1][j].length() < dp[i][j].length()) {
                            dp[i][j] = dp[i][k] + dp[k + 1][j];
                        }
                    }
                    for (int k = 0; k < sub.length(); k++) {
                        String temp = sub.substring(0, k + 1);
                        if (temp != null && sub.length() % temp.length() == 0
                           && sub.replaceAll(temp, "").length() == 0) {
                            String ss = sub.length() / temp.length() + "[" + dp[i][i + k] + "]";
                            if (ss.length() < dp[i][j].length()) {
                                dp[i][j] = ss;
                            }
                        }
                    }
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}