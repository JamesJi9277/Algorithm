class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int max = 0;
        int lengthOfMax = 0;
        for (char c : tasks) {
            int temp = ++count[c - 'A'];
            if (temp == max) {
                lengthOfMax++;
            } else if (temp > max) {
                max = temp;
                lengthOfMax = 1;
            }
        }
        return Math.max(tasks.length, (max - 1) * (n + 1) + lengthOfMax);
    }
}