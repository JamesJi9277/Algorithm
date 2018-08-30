class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }
        int max = 0;
        int longest = 0;
        int[] count = new int[26];
        for (char c : tasks) {
            int temp = ++count[c - 'A'];
            if (temp == max) {
                longest++;
            } else if (temp > max) {
                max = temp;
                longest = 1;
            }
        }
        return Math.max(tasks.length, (max - 1) * (n + 1) + longest);
    }
}