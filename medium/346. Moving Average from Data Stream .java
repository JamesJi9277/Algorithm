class MovingAverage {

    Queue<Integer> queue;
    int max;
    int curSum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<Integer>();
        max = size;
        curSum = 0;
    }
    
    public double next(int val) {
        queue.offer(val);
        curSum += val;
        if (queue.size() <= max) {
            return (double)curSum / queue.size();
        } else {
            curSum -= queue.poll();
            return (double)curSum / queue.size();
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */