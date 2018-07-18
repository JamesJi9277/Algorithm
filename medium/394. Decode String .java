class Solution {
    public String decodeString(String s) {
        Stack<Integer> count = new Stack<Integer>();
        Stack<String> stack = new Stack<String>();
        String res = "";
        int index = 0;
        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int count1 = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count1 = 10 * count1 + (s.charAt(index) - '0');
                    index++;
                }
                count.push(count1);
            } else if (s.charAt(index) == '[') {
                stack.push(res);
                index++;
                res = "";
            } else if (s.charAt(index) == ']') {
                StringBuilder sb = new StringBuilder(stack.pop());
                int count2 = count.pop();
                for (int i = 0; i < count2; i++) {
                    sb.append(res);
                }
                res = sb.toString();
                index++;
            } else {
                res += s.charAt(index);
                index++;
            }
        }
        return res;
    }



class Solution {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Stack<Integer> count = new Stack<>();
        Stack<String> stack = new Stack<>();
        String res = "";
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                int start = index;
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    index++;
                }
                count.push(Integer.parseInt(s.substring(start, index)));
            } else if (c == '[') {
                stack.push(res);
                index++;
                res = "";
            } else if (c == ']') {
                StringBuffer sb = new StringBuffer(stack.pop());
                int count1 = count.pop();
                for (int i = 0; i < count1; i++) {
                    sb.append(res);
                }
                res = sb.toString();
                index++;
            } else {
                res += s.charAt(index++);
            }
        }
        return res;
    }
}