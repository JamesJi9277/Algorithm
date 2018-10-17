class Solution {
    public int calculate(String s) {
        int res = 0;
        int curRes = 0;
        int num = 0;
        char op = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = 10 * num + (c - '0');
            } else if (c == '(') {
                int j = i;
                int count = 0;
                while (i < s.length()) {
                    if (s.charAt(i) == '(') {
                        count++;
                    } 
                    if (s.charAt(i) == ')') {
                        count--;
                    }
                    if (count == 0) {
                        break;
                    }
                }
                num = calculate(s.substring(j + 1, i - j - 1));
            }
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1) {
                switch (op) {
                    case '+' : curRes += num;
                        break;
                    case '-' : curRes -= num;
                        break;
                    case '*' : curRes *= num;
                        break;
                    case '/' : curRes /= num;
                        break;
                }
                if (c == '+' || c == '-' || i == s.length() - 1) {
                    res += curRes;
                    curRes = 0;
                }
                op = c;
                num = 0;
            }
        }
        return res;
    }
}