class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return res;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1] - b[0] - b[1]));
        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int[] temp = pq.poll();
            res.add(new int[]{temp[0], temp[1]});
            if (temp[2] + 1 < nums2.length) {
                temp = new int[]{temp[0], nums2[temp[2] + 1], temp[2] + 1};
                pq.offer(temp);
            }
        }
        return res;
    }
}