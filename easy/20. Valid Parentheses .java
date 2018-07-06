class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        HashMap<Character, Character> map = createMapping();
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else if (!stack.isEmpty() && map.get(stack.peek()) == c) {
                    stack.pop();
            }
            else {
                return false;
            }
        }
        return stack.isEmpty();
    }
    private HashMap<Character, Character> createMapping() {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        return map;
    }
}


class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (!stack.isEmpty() && map.containsKey(stack.peek()) && map.get(stack.peek()) == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}


class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else if (!stack.isEmpty() && map.get(stack.peek()) == c) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}

