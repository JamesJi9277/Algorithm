class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if (logs == null || logs.size() == 0) {
            return new int[n];
        }
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[n];
        for (String log : logs) {
            String[] strs = log.split(":");
            int index = Integer.valueOf(strs[0]);
            int time = Integer.valueOf(strs[2]);
            if (strs[1].equals("start")) {
                stack.push(new int[]{index, time});
            } else if (strs[1].equals("end")) {
                int diff = time - stack.pop()[1] + 1;
                res[index] += diff;
                if (!stack.isEmpty()) {
                    res[stack.peek()[0]] -= diff;
                }
            }
        }
        return res;
    }
}