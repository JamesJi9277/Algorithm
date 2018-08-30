class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (n < 0 || k > n || k < 0) {
            return res;
        }
        List<Integer> temp = new ArrayList<>();
        helper(res, temp, n, k, 1);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> temp, int n, int k, int index) {
        if (temp.size() == k) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = index; i <= n; i++) {
            temp.add(i);
            helper(res, temp, n, k, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}