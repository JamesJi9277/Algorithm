class Solution {
    public int maxDistToClosest(int[] seats) {
        //找最长连续的0,三种情况
        int first = -1;
        int last = -1;
        int max = -1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                continue;
            }
            max = Math.max(max, i - last);
            if (first == -1) {
                first = i;
            }
            last = i;
        }
        return Math.max(first, Math.max(seats.length - 1 - last, max / 2));
    }
}