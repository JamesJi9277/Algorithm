/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

// brute force
// every bofy knows i but i doesn't know everyone else
public class Solution extends Relation {
    public int findCelebrity(int n) {
        for (int i = 0; i < n; i++) {
            int j = 0;
            for (j = 0; j < n; j++) {
                if (j == i) {
                    continue;
                }
                if (!(knows(j, i) && !knows(i, j))) {
                    break;
                }
            }
            if (j == n) {
                return i;
            }
        }
        return -1;
    }
}


public class Solution extends Relation {
    public int findCelebrity(int n) {
        int res = 0;
        for (int i = 1; i < n; i++) {
            if (knows(res, i)) {
                res = i;
            }
        }
        for (int i = 0; i < res; i++) {
            if (knows(res, i)) {
                return -1;
            }
        }
        for (int i = res + 1; i < n; i++) {
            if (!knows(i, res)) {
                return -1;
            }
        }
        return res;
    }
}