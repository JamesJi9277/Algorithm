class Solution {
    int count = 0;
    public int countArrangement(int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[n];
        helper(res, temp, nums, visited);
        return count;
    }
    private void helper(List<List<Integer>> res, List<Integer> temp, List<Integer> nums, boolean[] visited) {
        if (nums.size() == temp.size()) {
            count++;
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (visited[nums.get(i) - 1]) {
                continue;
            }
            if ((nums.get(i) % (temp.size() + 1) == 0 || (temp.size() + 1) % nums.get(i) == 0)) {
                visited[nums.get(i) - 1] = true;
                temp.add(nums.get(i));
                helper(res, temp, nums, visited);
                temp.remove(temp.size() - 1);
                visited[nums.get(i) - 1] = false;
            }
        }
    }
}