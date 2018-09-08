class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (set.add(n)) {
            set.add(n);
            n = helper(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }
    private int helper(int n) {
        int res = 0;
        while (n != 0) {
            int temp = n % 10;
            res += temp * temp;
            n /= 10;
        }
        return res;
    }
}