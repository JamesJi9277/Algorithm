class Solution {
    public String solveEquation(String equation) {
        String[] strs = equation.split("=");
        int[] left = helper(strs[0]);
        int[] right = helper(strs[1]);
        int x = left[0] - right[0];
        int num = right[1] - left[1];
        if (x == 0 && num == 0) {
            return "Infinite solutions";
        }
        if (x == 0) {
            return "No solution";
        }
        int res = num / x;
        return "x=" + res;
    }
    private int[] helper(String s1) {
        String[] strs = s1.split("(?=[+-])");
        int[] res = new int[2];
        for (String s : strs) {
            if (s.equals("+x") || s.equals("x")) {
                res[0]++;
            } else if (s.equals("-x")) {
                res[0]--;
            } else if (s.contains("x")) {
                res[0] += Integer.valueOf(s.substring(0, s.indexOf("x")));
            } else {
                res[1] += Integer.valueOf(s);
            }
        }
        return res;
    }
}