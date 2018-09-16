/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int cele = 0;
        for (int i = 1; i < n; i++) {
            if (knows(cele, i)) {
                cele = i;
            }
        }
        for (int i = 0; i < cele; i++) {
            if (knows(cele, i)) {
                return -1;
            }
        }
        for (int i = cele + 1; i < n; i++) {
            if (!knows(i, cele)) {
                return -1;
            }
        }
        return cele;
    }
}