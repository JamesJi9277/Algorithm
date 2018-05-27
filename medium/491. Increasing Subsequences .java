class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        List<Integer> temp = new ArrayList<Integer>();
        HashSet<List<Integer>> set = new HashSet<>();
        helper(nums, res, temp, 0, set);
        return res;
    }
    private void helper(int[] nums, List<List<Integer>> res, List<Integer> temp, int index, HashSet<List<Integer>> set) {
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            if (valid(temp) && !set.contains(temp)) {
                res.add(new ArrayList<Integer>(temp));
                set.add(temp);
            }
            helper(nums, res, temp, i + 1, set);
            temp.remove(temp.size() - 1);
        }
    }
    private boolean valid(List<Integer> list) {
        if (list.size() < 2) {
            return false;
        }
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}

public class Solution {

     public List<List<Integer>> findSubsequences(int[] nums) {
         Set<List<Integer>> res= new HashSet<List<Integer>>();
         List<Integer> holder = new ArrayList<Integer>();
         findSequence(res, holder, 0, nums);
         List result = new ArrayList(res);
         return result;
     }

    public void findSequence(Set<List<Integer>> res, List<Integer> holder, int index, int[] nums) {
        if (holder.size() >= 2) {
            res.add(new ArrayList(holder));
        }
        for (int i = index; i < nums.length; i++) {
            if(holder.size() == 0 || holder.get(holder.size() - 1) <= nums[i]) {
                holder.add(nums[i]);
                findSequence(res, holder, i + 1, nums);
                holder.remove(holder.size() - 1);
            }
        }
    }
}