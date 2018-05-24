class Solution {

    HashMap<Integer, List<Integer>> map;
    public Solution(int[] nums) {
        map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
    }
    
    public int pick(int target) {
        if (map.containsKey(target)) {
            List<Integer> list = map.get(target);
            if (list.size() == 1) {
                return list.get(0);
            } else {
                int random = new Random().nextInt(list.size());
                return list.get(random);
            }
        }
        return 0;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */