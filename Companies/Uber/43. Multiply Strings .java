class Solution {
    public String multiply(String num1, String num2) {
        // two Strings are non negative
        //`num1[i] * num2[j]` will be placed at indices `[i + j`, `i + j + 1]` 
        if (num1 == null || num2 == null) {
            return num1 == null ? num2 : num1;
        }
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        int[] res = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                res[i + j] = res[i + j] + (res[i + j + 1] + temp) / 10;
                res[i + j + 1] = (res[i + j + 1] + temp) % 10;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i : res) {
            if (i > 0 || sb.length() > 0) {
                sb.append(i);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}