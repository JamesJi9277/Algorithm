class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        helper(candidates, target, res, temp, 0, 0);
        return res;
    }
    private void helper(int[] candidates, int target, List<List<Integer>> res, List<Integer> temp, int sum, int index) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i != index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            sum += candidates[i];
            temp.add(candidates[i]);
            helper(candidates, target, res, temp, sum, i + 1);
            sum -= candidates[i];
            temp.remove(temp.size() - 1);
        }
    }
}