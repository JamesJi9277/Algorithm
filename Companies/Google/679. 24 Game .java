class Solution {
    public boolean judgePoint24(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        List<Double> res = new ArrayList<>();
        for (int i : nums) {
            res.add((double)i);
        }
        return dfs(res);
    }
    private boolean dfs(List<Double> res) {
        if (res.size() == 1) {
            if (res.get(0) == 24) {
                return true;
            }
            return false;
        }
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < i; j++) {
                Double num1 = res.get(i);
				Double num2 = res.get(j);
				
				//construct a list of numbers we could get from manipulating those two numbers
				List<Double> next = new ArrayList<>();
				next.addAll(Arrays.asList(num1 + num2, num1 - num2, num2 - num1, num1 * num2));
				if (num1 != 0) next.add(num2 / num1);
				if (num2 != 0) next.add(num1 / num2);
                res.remove(i);
                res.remove(j);
                
                for (Double k : next) {
                    res.add(k);
                    if (dfs(res)) {
                        return true;
                    }
                    res.remove(res.size() - 1);
                }
                
                res.add(j, num2);
                res.add(i, num1);
            }
        }
        return false;
    }
}


