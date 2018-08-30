class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                // should pay attention at get sum part
                // should first caculate carry incase of override original value
                int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int carry = (temp + res[i + j + 1]) / 10;
                res[i + j] = res[i + j] + carry;
                res[i + j + 1] = (res[i + j + 1] + temp) % 10;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i : res) {
            if (sb.length() > 0 || i > 0) {
                sb.append(i);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

// second write, bug free
class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
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