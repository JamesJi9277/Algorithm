class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        helper(res, temp, candidates, target, 0, 0);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int sum, int index) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i != index && candidates[i - 1] == candidates[i]) {
                continue;
            }
            temp.add(candidates[i]);
            sum += candidates[i];
            helper(res, temp, candidates, target, sum, i + 1);
            temp.remove(temp.size() - 1);
            sum -= candidates[i];
        }
    }
}

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        helper(res, temp, candidates, target, 0);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target,int index) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i != index && candidates[i - 1] == candidates[i]) {
                continue;
            }
            temp.add(candidates[i]);
            target -= candidates[i];
            helper(res, temp, candidates, target, i + 1);
            temp.remove(temp.size() - 1);
            target += candidates[i];
        }
    }
}