class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<int[]> stack = new Stack<>();
        for (String s : logs) {
            String[] strs = s.split(":");
            int index = Integer.valueOf(strs[0]);
            int time = Integer.valueOf(strs[2]);
            if (strs[1].equals("start")) {
                stack.push(new int[]{index, time});
            } else {
                // 整体这个大时间是一个diff
                int diff = time - stack.pop()[1] + 1;
                // 接下来再是微调
                res[index] += diff;
                if (!stack.isEmpty()) {
                    res[stack.peek()[0]] -= diff;
                }
            }
        }
        return res;
    }
}