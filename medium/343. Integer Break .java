class Solution {
    public int integerBreak(int n) {
        if (n < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, Math.max((n - i) * i, i * integerBreak(n - i)));
        }
        return res;
    }
}


class Solution {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int integerBreak(int n) {
        if (n < 2) {
            return 0;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, Math.max(i * (n - i), i * integerBreak(n - i)));
        }
        map.put(n, res);
        return res;
    }
}