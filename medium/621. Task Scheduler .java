/* considering a tasks AAABBBBCCCC, n = 2;
 * find the character with highest frequency (maxLen) and how many of those characters, here are B and C with maxLen (4)
 * there are two characters with maxLen, so count = 2; 
 * in order to accormodate all B and C, at least we need;
 * C B _ C B _ C B _ C B  (max - 1) * (1 + n) + count, 
 * all other characters can be placed in the idle position, or squeeze in the middle
 * int this we can put A as C B A C B A C B A C B;
 * if the task is AAADDDBBBBCCCC, n = 2;
 * after putting A, all idle positions are occupied, so squeeze D in to the sequence as
 * C B A D C B A D C B A D C B
 */
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