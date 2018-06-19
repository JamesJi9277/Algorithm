public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        helper(new LinkedList<Integer>(), 0, nums, res);
        return res; 
    }
    private void helper(LinkedList<Integer> list, int index, int[] nums, List<List<Integer>> res){
        if(list.size()>1) res.add(new LinkedList<Integer>(list));
        Set<Integer> used = new HashSet<>();
        for(int i = index; i<nums.length; i++){
            if(used.contains(nums[i])) continue;
            if(list.size()==0 || nums[i]>=list.peekLast()){
                used.add(nums[i]);
                list.add(nums[i]); 
                helper(list, i+1, nums, res);
                list.remove(list.size()-1);
            }
        }
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

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        helper(res, temp, nums, 0);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> temp, int[] nums, int index) {
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            if (temp.size() >= 2 && !res.contains(temp) && temp.get(temp.size() - 1) >= temp.get(temp.size() - 2)) {
                res.add(new ArrayList<Integer>(temp));
            }
            helper(res, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}