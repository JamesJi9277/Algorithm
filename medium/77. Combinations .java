class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (n < 0 || n < k) {
            return res;
        }
        List<Integer> temp = new ArrayList<Integer>();
        helper(res, temp, n, k, 1);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> temp, int n, int k, int start) {
        if (temp.size() == k) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = start; i <= n; i++) {
            if (temp.contains(i)) {
                continue;
            }
            temp.add(i);
            helper(res, temp, n, k, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}