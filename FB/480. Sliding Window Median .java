class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Double> minHeap = new PriorityQueue<>();
        // if (k > nums.length) {
        //     for (double i : nums) {
        //         maxHeap.offer(i);
        //         minHeap.offer(maxHeap.poll());
        //         if (minHeap.size() > maxHeap.size()) {
        //             maxHeap.offer(minHeap.poll());
        //         }
        //     }
        //     if (minHeap.size() == maxHeap.size()) {
        //         return new double[]{(maxHeap.peek() + minHeap.peek()) / 2};
        //     } else {
        //         return new double[]{maxHeap.peek()};
        //     }
        // }
        double[] res = new double[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k - 1) {
                if (maxHeap.contains((double)nums[i - k])) {
                    maxHeap.remove((double)nums[i - k]);
                } else if (minHeap.contains((double)nums[i - k])) {
                    minHeap.remove((double)nums[i - k]);
                }
            }
            maxHeap.offer((double)nums[i]);
            minHeap.offer(maxHeap.poll());
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
            if (i >= k - 1) {
                if (maxHeap.size() == minHeap.size()) {
                    res[index++] = (double)(maxHeap.peek() + minHeap.peek()) / 2.0;
                } else {
                    res[index++] = maxHeap.peek();
                }
            }
        }
        return res;
    }
}