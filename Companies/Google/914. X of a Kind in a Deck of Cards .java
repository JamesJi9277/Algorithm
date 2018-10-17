class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck == null || deck.length == 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : deck) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res = getGcd2(res, entry.getValue());
        }
        return res > 1;
    }
    private int getGcd1(int a, int b) {
        while (b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }
    private int getGcd2(int a, int b) {
        return b == 0 ? a : getGcd2(b, a % b);
    }
}