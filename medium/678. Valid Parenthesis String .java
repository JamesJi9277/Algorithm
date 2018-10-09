class Solution {
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left.push(i);
            } else if (c == ')') {
                if (!left.isEmpty()) {
                    left.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            } else {
                star.push(i);
            }
        }
        while (!left.isEmpty() && !star.isEmpty()) {
            int i = left.pop();
            int j = star.pop();
            // 这里的i > j报错是因为我之前是先pop的left，所以无论如何*的index都要比(的要大
            if (j < i) {
                return false;
            }
        }
        return left.isEmpty();
    }
}

class Solution {
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        return helper(s, 0, 0);
    }
    private boolean helper(String s, int index, int leftCount) {
        if (leftCount < 0) {
            return false;
        }
        if (index == s.length()) {
            return leftCount == 0;
        }
        if (s.charAt(index) == '(') {
            return helper(s, index + 1, leftCount + 1);
        } else if (s.charAt(index) == ')') {
            return helper(s, index + 1, leftCount - 1);
        } else {
            return helper(s, index + 1, leftCount) || helper(s, index + 1, leftCount + 1) || helper(s, index + 1, leftCount - 1);
        }
    }
}

class Solution {
    public boolean checkValidString(String s) {
        int min = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                min++;
            } else {
                min--;
            }
            if (c != ')') {
                max++;
            } else {
                max--;
            }
            if (max < 0) {
                return false;
            }
            min = Math.max(min, 0);
        }
        return min == 0;
    }
}