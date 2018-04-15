class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<Integer>();
        helper(candidates, res, temp, target, 0);
        return res;
    }
    private void helper(int[] candidates, List<List<Integer>> res, List<Integer> temp, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        if (target < 0 || start >= candidates.length) {
            // 因为所有数都是正数，才可以有这个返回条件
            return;
        }
    
        for (int i = start; i < candidates.length; i++) {
            // 避免结果有重复
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            temp.add(candidates[i]);
            helper(candidates, res, temp, target - candidates[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}