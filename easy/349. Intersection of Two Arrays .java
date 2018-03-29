class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        HashSet<Integer> set1 = constructSet(nums1);
        HashSet<Integer> set2 = new HashSet<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for (int i : nums2) {
            if (set1.contains(i) && !set2.contains(i)) {
                list.add(i);
                set2.add(i);
            }
        }
        return helper(list);
    }
    private HashSet<Integer> constructSet(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            if (!set.contains(i)) {
                set.add(i);
            }
        }
        return set;
    }
    private int[] helper(List<Integer> list) {
        int[] nums = new int[list.size()];
        int j = 0;
        for (int i : list) {
            nums[j++] = i;
        }
        return nums;
    }
}