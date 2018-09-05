class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null) {
            return 0;
        }
        int[] count = new int[26];
        int max = 0;
        int maxLength = 0;
        for (char c : tasks) {
            int temp = ++count[c - 'A'];
            if (temp == max) {
                maxLength++;
            } else if (temp > max) {
                max = temp;
                maxLength = 1;
            }
        }
        return Math.max(tasks.length, (n + 1) * (max - 1) + maxLength);
    }
}