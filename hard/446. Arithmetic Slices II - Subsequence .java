// brute force, also can print out all results
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        helper(nums, res, temp, 0);
        for (List<Integer> list : res) {
            if (list.size() > 2 && isValid(list)) {
                count++;
            }
        }
        return count;
    }
    private void helper(int[] nums, List<List<Integer>> res, List<Integer> temp, int index) {
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            res.add(new ArrayList<Integer>(temp));
            helper(nums, res, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
    private boolean isValid(List<Integer> list) {
        long diff = (long)list.get(1) - (long)list.get(0);
        for (int i = 0; i < list.size() - 1; i++) {
            if ((long)list.get(i + 1) - (long)list.get(i) != (long)diff) {
                return false;
            }
        }
        return true;
    }
}


class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer>[] map = new HashMap[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            map[i] = new HashMap<Integer, Integer>();
            int num = nums[i];
            for (int j = 0; j < i; j++) {
                if ((long)nums[i] - nums[j] > Integer.MAX_VALUE || 
                    (long)nums[i] - nums[j] < Integer.MIN_VALUE) {
                    continue;
                }
                int diff = nums[i] - nums[j];
                int count = map[j].getOrDefault(diff, 0);
                map[i].put(diff, map[i].getOrDefault(diff, 0) + count + 1);
                res += count;
            }
        }
        return res;
    }
}