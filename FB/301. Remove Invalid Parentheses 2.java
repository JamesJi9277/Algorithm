class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) {
            return res;
        }
        helper(res, s, 0, 0, new char[]{'(', ')'});
        return res;
    }
    private void helper(List<String> res, String s, int lastI, int lastJ, char[] check) {
        int count = 0;
        int i = lastI;
        while (i < s.length() && count >= 0) {
            char c = s.charAt(i);
            if (c == check[0]) {
                count++;
            } else if (c == check[1]) {
                count--;
            }
            i++;
        }
        if (count >= 0) {
            // remove '('
            String reverse = new StringBuffer(s).reverse().toString();
            if (check[0] == '(') {
                helper(res, reverse, 0, 0, new char[]{')', '('});
            } else {
                res.add(reverse);
            }
        } else {
            i--;
            for (int j = lastJ; j <= i; j++) {
                // find first ')'
                if (s.charAt(j) == check[1] && (j == lastJ || s.charAt(j - 1) != check[1])) {
                    String temp = s.substring(0, j) + s.substring(j + 1, s.length());
                    helper(res, temp, i, j, check);
                }
            }
        }
    }
}


class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) {
            return res;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s);
        visited.add(s);
        boolean found = false;
        while (!queue.isEmpty()) {
             int size = queue.size();
             for (int i = 0; i < size; i++) {
                String temp = queue.poll();
                if (isValid(temp)) {
                    res.add(temp);
                    found = true;
                }
                if (found) {
                    continue;
                }
                for (int j = 0; j < temp.length(); j++) {
                    if (temp.charAt(j) != '(' && temp.charAt(j) != ')') {
                        continue;
                    }
                    String temp1 = temp.substring(0, j) + temp.substring(j + 1);
                    if (!visited.contains(temp1)) {
                        queue.offer(temp1);
                        visited.add(temp1);
                    }
                }
             }
        }
        return res;
    }
    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            }
            if (c == ')' && count-- == 0) {
                return false;
            }
        }
        return count == 0;
    }
}