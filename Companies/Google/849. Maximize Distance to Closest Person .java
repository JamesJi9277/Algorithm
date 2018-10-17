class Solution {
    public int maxDistToClosest(int[] seats){
        int res = Integer.MIN_VALUE;
        int j = -1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (j == -1) {
                    res = Math.max(res, i);
                } else {
                    res = Math.max(res, (i - j) / 2);
                }
                j = i;
            }
        }
        if (seats[seats.length - 1] == 0) {
            res = Math.max(res, seats.length - 1 - j);
        }
        return res;
    }
}

class Solution {
    public int maxDistToClosest(int[] seats) {
        int res = 0;
        int j = -1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (j == -1) {
                    res = Math.max(res, i);
                } else {
                    res = Math.max(res, (i - j) / 2);
                }
                j = i;
            }
        }
        if (seats[seats.length - 1] == 0) {
            res = Math.max(res, seats.length - 1 - j);
        }
        return res;
    }
}