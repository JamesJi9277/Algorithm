class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<Integer>();
        if (right < left) {
            return res;
        }
        for (int i = left; i <= right; i++) {
            if (isValid(i)) {
                res.add(i);
            }
        }
        return res;
    }
    private boolean isValid(int i) {
        int n = i;
        while (i != 0) {
            int digit = i % 10;
            // 这里是个坑
            if (digit == 0) {
                return false;
            }
            if (n % digit != 0) {
                return false;
            }
            i /= 10;
        }
        return true;
    }
}