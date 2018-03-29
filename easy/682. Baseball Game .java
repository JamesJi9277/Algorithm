// 题目其实并不难，需要细致才能够bug free
class Solution {
    public int calPoints(String[] ops) {
        if (ops == null || ops.length == 0) {
            return 0;
        }
        int sum = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("+")) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                int temp3 = temp1 + temp2;
                sum += temp3;
                //这里的顺序需要弄清楚
                stack.push(temp2);
                stack.push(temp1);
                stack.push(temp3);
            } else if (ops[i].equals("C")) {
                int temp1 = stack.pop();
                sum -= temp1;
            } else if (ops[i].equals("D")) {
                int temp1 = stack.pop();
                int temp2 = 2 * temp1;
                sum += temp2;
                stack.push(temp1);
                stack.push(temp2);
            } else {
                int temp = Integer.parseInt(ops[i]);
                sum += temp;
                stack.push(temp);
            }
        }
        return sum;
    }
}