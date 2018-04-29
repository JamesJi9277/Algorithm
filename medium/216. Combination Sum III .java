class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (k < 0) {
            return res;
        }
        List<Integer> temp = new ArrayList<Integer>();
        helper(res, temp, 0, n, k, 1);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> temp, int tempSum, int sum, int count, int start) {
        if (temp.size() == count && tempSum == sum) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = start; i <= 9; i++) {
            temp.add(i);
            tempSum += i;
            helper(res, temp, tempSum, sum, count, i + 1);
            tempSum -= i;
            temp.remove(temp.size() - 1);
        }
    }
}