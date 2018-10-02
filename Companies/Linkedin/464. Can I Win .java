class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) {
            return true;
        }
        int sum = (maxChoosableInteger + 1) * maxChoosableInteger / 2;
        if (sum < desiredTotal) {
            return false;
        }
        Map<Integer, Boolean> map = new HashMap<>();
        boolean[] used = new boolean[maxChoosableInteger + 1];
        return helper(desiredTotal, used, map);
    }
    private boolean helper(int desiredTotal, boolean[] used, Map<Integer, Boolean> map) {
        if (desiredTotal <= 0) {
            return false;
        }
        int key = format(used);
        if (!map.containsKey(key)) {
            for (int i = 1; i < used.length; i++) {
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                if (!helper(desiredTotal - i, used, map)) {
                    map.put(key, true);
                    used[i] = false;
                    return true;
                }
                used[i] = false;
            }
            map.put(key, false);   
        }
        return map.get(key);
    }
    private int format(boolean[] array) {
        int num = 0;
        int weight = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i]) {
                num += weight;
            }
            weight *= 2;
        }
        return num;
    }
}


class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
        if (sum < desiredTotal) {
            return false;
        }
        Map<Integer, Boolean> map = new HashMap<>();
        boolean[] used = new boolean[maxChoosableInteger + 1];
        return helper(desiredTotal, used, map);
    }
    private boolean helper(int desiredTotal, boolean[] used, Map<Integer, Boolean> map) {
        if (desiredTotal <= 0) {
            return false;
        }
        int key = format(used);
        if (!map.containsKey(key)) {
            for (int i = 1; i < used.length; i++) {
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                if (!helper(desiredTotal - i, used, map)) {
                    map.put(key, true);
                    used[i] = false;
                    return true;
                }
                used[i] = false;
            }
            map.put(key, false);
        }
        return map.get(key);
    }
    private int format(boolean[] array) {
        int num = 0;
        int weight = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i]) {
                num += weight;
            }
            weight *= 2;
        }
        return num;
    }
}