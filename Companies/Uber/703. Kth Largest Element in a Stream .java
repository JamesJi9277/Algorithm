class KthLargest {

    PriorityQueue<Integer> pq;
    int k;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for (int i : nums) {
            if (pq.size() < k) {
                pq.offer(i);
            } else {
                if (i > pq.peek()) {
                    pq.poll();
                    pq.offer(i);
                }
            }
        }
    }
    
    public int add(int val) {
        if (pq.size() < k) {
                pq.offer(val);
        } else {
            if (val > pq.peek()) {
                pq.poll();
                pq.offer(val);
            }
        }
        return pq.peek();
    }
}