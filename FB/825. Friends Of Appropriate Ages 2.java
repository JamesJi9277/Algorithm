class Solution {
    public int numFriendRequests(int[] ages) {
        if (ages == null || ages.length == 0) {
            return 0;
        }
        int count = 0;
        int[] map = new int[121];
        for (int age : ages) {
            map[age]++;
        }
        for (int A = 1; A <= 120; A++) {
            for (int B = 1; B <= 120; B++) {
                if (B <= 0.5 * A + 7) {
                    continue;
                }
                if (B > A) {
                    continue;
                }
                if (B > 100 && A < 100) {
                    continue;
                }
                count += map[A] * map[B];
                if (A == B) {
                    count -= map[A];
                }
            }
        }
        return count;
    }
}