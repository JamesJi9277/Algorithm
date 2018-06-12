class Solution {
    public int[] dailyTemperatures(int[] temp) {
        if (temp == null || temp.length == 0) {
            return temp;
        }
        int[] res = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            for (int j = i + 1; j < temp.length; j++) {
                if (temp[j] > temp[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }
}
//单调栈的做法
class Solution {
    public int[] dailyTemperatures(int[] temp) {
        if (temp == null || temp.length == 0) {
            return temp;
        }
        int[] res = new int[temp.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temp.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && temp[stack.peek()] < temp[i]) {
                    int index = stack.pop();
                    res[index] = i - index;
                }
                stack.push(i);
            }
        }
        return res;
    }
}