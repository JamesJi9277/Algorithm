class HitCounter {

    PriorityQueue<Integer> pq;
    /** Initialize your data structure here. */
    public HitCounter() {
        pq = new PriorityQueue<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        pq.offer(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!pq.isEmpty() && (pq.peek() + 300 <= timestamp)) {
            pq.poll();
        }
        return pq.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */