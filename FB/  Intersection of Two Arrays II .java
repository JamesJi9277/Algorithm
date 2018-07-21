class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        Map<Integer, Integer> count1 = new HashMap<>();
        List<Integer> temp = new ArrayList<>();
        for (int i : nums1) {
            count1.put(i, count1.getOrDefault(i, 0) + 1);
        }
        for (int i : nums2) {
            if (count1.containsKey(i) && count1.get(i) > 0) {
                temp.add(i);
                count1.put(i, count1.get(i) - 1);
            }
        }
        int[] res = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            res[i] = temp.get(i);
        }
        return res;
    }
}