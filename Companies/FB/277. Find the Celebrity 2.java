/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        for (int i = 0; i < n; i++) {
            int j;
            for (j = 0; j < n; j++) {
                if (i == j) {
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

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

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
        for (int i = res; i < n; i++) {
            if (!knows(i, res)) {
                return -1;
            }
        }
        return res;
    }
}