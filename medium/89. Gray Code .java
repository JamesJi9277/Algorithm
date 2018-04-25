class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if (n < 0) {
            return res;
        }
        if (n == 0) {
            res.add(0);
            return res;
        }
        res = grayCode(n - 1);
        int addNumber = 1 << (n - 1);
        for (int i = res.size() - 1; i >= 0; i--) {
            res.add(addNumber + res.get(i));
        }
        return res;
    }
}