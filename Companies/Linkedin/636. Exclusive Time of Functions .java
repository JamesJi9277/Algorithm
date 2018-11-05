class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<int[]> stack = new Stack<>();
        for (String log : logs) {
            String[] str = log.split(":");
            int index = Integer.valueOf(str[0]);
            int time = Integer.valueOf(str[2]);
            if (str[1].equals("start")) {
                stack.push(new int[]{index, time});
            } else {
                int[] temp = stack.pop();
                int diff = time - temp[1] + 1;
                res[index] += diff;
                if (!stack.isEmpty()) {
                    res[stack.peek()[0]] -= diff;
                }
            }
        }
        return res;
    }
}