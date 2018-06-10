class Solution {
    int times = -1;
    public int minMutation(String start, String end, String[] bank) {
        if (bank == null || bank.length == 0) {
            return times;
        }
        boolean[] visited = new boolean[bank.length];
        helper(start, end, bank, visited, 0);
        return times;
    }
    private void helper(String start, String end, String[] bank, boolean[] visited, int t) {
        if (start.equals(end)) {
            if (times != -1) {
                times = Math.min(times, t);
            } else {
                times = t;
            }
        }
        char[] s = start.toCharArray();
        for (int i = 0; i < bank.length; i++) {
            if (visited[i]) {
                continue;
            }
            char[] e = bank[i].toCharArray();
            if (s.length != e.length) {
                continue;
            }
            int diff = 0;
            for (int j = 0; j < s.length; j++) {
                if (s[j] != e[j]) {
                    diff++;
                }
            }
            if (diff == 1) {
                visited[i] = true;
                helper(bank[i], end, bank, visited, t + 1);
                visited[i] = false;
            }
        }
    }
}