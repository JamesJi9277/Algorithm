class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) {
            return asteroids;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i : asteroids) {
            if (i > 0) {
                stack.push(i);
            } else if (i < 0) {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -i) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() > 0 && stack.peek() == -i) {
                    stack.pop();
                    continue;
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(i);
                }
            }
        }
        int[] res = new int[stack.size()];
        int index = 0;
        for (int i : stack) {
            res[index++] = i;
        }
        return res;
    }
}