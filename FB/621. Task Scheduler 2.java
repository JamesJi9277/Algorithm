class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }
        int max = 0;
        int maxCount = 0;
        char[] count = new char[26];
        for (char c : tasks) {
            int temp = ++count[c - 'A'];
            if (temp == max) {
                maxCount++;
            } else if (temp > max) {
                max = temp;
                maxCount = 1;
            }
        }
        return Math.max(tasks.length, (max - 1) * (n + 1) + maxCount);
    }
}