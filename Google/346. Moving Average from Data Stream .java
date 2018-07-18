class MovingAverage {

    Queue<Integer> queue;
    int sum;
    int limit;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        sum = 0;
        limit = size;
    }
    
    public double next(int val) {
        if (queue.size() < limit) {
            sum += val;
            queue.offer(val);
            return (double)sum / queue.size();
        } else {
            sum -= queue.poll();
            sum += val;
            queue.offer(val);
            return (double)sum / queue.size();
        }
    }
}
