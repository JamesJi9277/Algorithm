class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        List<Integer> temp = new ArrayList<Integer>();
        helper(candidates, res, temp, target, 0);
        return res;
    }
    private void helper(int[] candidates, List<List<Integer>> res, List<Integer> temp, int target, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            helper(candidates, res, temp, target - candidates[i], i);
            temp.remove(temp.size() - 1);
        }
    }
}


class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        List<Integer> temp = new ArrayList<>();
        helper(res, temp, candidates, target, 0, 0);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int index, int sum) {
        if (index == candidates.length || sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            sum += candidates[i];
            temp.add(candidates[i]);
            helper(res, temp, candidates, target, i, sum);
            sum -= candidates[i];
            temp.remove(temp.size() - 1);
        }
    }
}