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
        int[] map = new int[26];
        int max = 0;
        int count = 0;
        for (char c : tasks) {
            int index = c - 'A';
            map[index]++;
            if (map[index] == max) {
                count++;
            } else if (map[index] > max) {
                count = 1;
                max = map[index];
            }
        }
        return Math.max(tasks.length, (max - 1) * (n + 1) + count);
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }
        int count = 0;
        int max = 0;
        int[] map = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            map[tasks[i] - 'A']++;
            if (map[tasks[i] - 'A'] == max) {
                count++;
            } else if (map[tasks[i] - 'A'] > max) {
                max = map[tasks[i] - 'A'];
                count = 1;
            }
        }
        return Math.max((n + 1) * (max - 1) + count, tasks.length);
    }
}