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


class Solution {
    class Pair {
        int x;
        int y;
        int sum;
        public Pair(int x, int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
    }
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.sum - b.sum));
        for (int i : nums1) {
            for (int j : nums2) {
                pq.offer(new Pair(i, j, i + j));
            }
        }
        while (!pq.isEmpty() && res.size() < k) {
            Pair p = pq.poll();
            res.add(new int[]{p.x, p.y});
        }
        return res;
    }
}