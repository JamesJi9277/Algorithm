class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<int[]>();
        if(nums1.length == 0 || nums2.length == 0 || k == 0) return res;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (a[0] + a[1] - b[0] - b[1]));
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                pq.offer(new int[]{nums1[i], nums2[j]});
            }
        }
        for(int i = 0;i < k; i++){
            if (pq.isEmpty()) {
                break;
            }
            res.add(pq.poll());
        }
        return res;
    }
}