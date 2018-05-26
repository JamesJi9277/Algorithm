https://leetcode.com/problems/can-i-win/discuss/95277/Java-solution-using-HashMap-with-detailed-explanation

class Solution {
    Map<Integer, Boolean> map;
    boolean[] used;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        map = new HashMap<Integer, Boolean>();
        used = new boolean[maxChoosableInteger + 1];
        int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (sum < desiredTotal) {
            return false;
        }
        if (desiredTotal <= 0) {
            return true;
        }
        return helper(desiredTotal);
    }
    private boolean helper(int desiredTotal) {
        if (desiredTotal <= 0) {
            return false;
        }
        int key = format(used);
        if (!map.containsKey(key)) {
            for (int i = 1; i < used.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    // if other one will lose for sure
                    if (!helper(desiredTotal - i)) {
                        map.put(key, true);
                        used[i] = false;
                        return true;
                    }
                    used[i] = false;
                }
            }
            map.put(key, false);
        }
        return map.get(key);
    }
    private int format(boolean[] used) {
        int num = 0;
        for (boolean b : used) {
            num <<= 1;
            if (b) {
                num |= 1;
            }
        }
        return num;
    }
}