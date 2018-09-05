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

class Solution {
    int count;
    public int countArrangement(int n) {
        if (n < 1) {
            return 0;
        }
        int[] nums = new int[n + 1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }
        helper(nums, n);
        return count;
    }
    private void helper(int[] nums, int start) {
        // 满足所有条件
        if (start == 0) {
            count++;
            return;
        }
        for (int i = start; i > 0; i--) {
            swap(nums, start, i);
            if (nums[start] % start == 0 || start % nums[start] == 0) {
                helper(nums, start - 1);
            }
            swap(nums, i, start);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}



public class Solution {
    public int countArrangement(int N) {
        dfs(N, N, new boolean[N + 1]);
        return count;
    }
    
    int count = 0;
    
    void dfs(int N, int k, boolean[] visited) {
        if (k == 0) {
            count++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (visited[i] || k % i != 0 && i % k != 0) {
                continue;
            }
            visited[i] = true;
            dfs(N, k - 1, visited);
            visited[i] = false;
        }
    }
}