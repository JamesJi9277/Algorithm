class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int[] res = new int[triangle.size()];
        res[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            res[i] = res[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j >= 1; j--) {
                res[j] = Math.min(res[j], res[j - 1]) + triangle.get(i).get(j);
            }
            res[0] = res[0] + triangle.get(i).get(0);
        }
        int sum = Integer.MAX_VALUE;
        for (int i : res) {
            sum = Math.min(sum, i);
        }
        return sum;
    }
}


class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        List<Integer> res = new ArrayList<Integer>();
        res.add(Integer.MAX_VALUE);
        helper(triangle, res, 0, 0, 0);
        return res.get(0);
    }
    private void helper(List<List<Integer>> triangle, List<Integer> res, int i, int j, int sum) {
        if (i == triangle.size()) {
            if (res.get(0) > sum) {
                res.add(0, sum);
            }
            return;
        }
        helper(triangle, res, i + 1, j, sum + triangle.get(i).get(j));
        helper(triangle, res, i + 1, j + 1, sum + triangle.get(i).get(j));
    }
}