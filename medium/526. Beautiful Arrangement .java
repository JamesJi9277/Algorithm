class Solution {
    public int countArrangement(int n) {
        if (n < 1) {
            return 0;
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        int count = 0;
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        helper(res, temp, nums);
        for (List<Integer> list : res) {
            if (isValid(list)) {
                count++;
            }
        }
        return count;
    }
    private void helper(List<List<Integer>> res, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            helper(res, temp, nums);
            temp.remove(temp.size() - 1);
        }
    }
    private boolean isValid(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (!((i + 1) % list.get(i) == 0 || list.get(i) % (i + 1) == 0)) {
                return false;
            }
        }
        return true;
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