class MedianFinder {

    List<Integer> array;
    /** initialize your data structure here. */
    public MedianFinder() {
        array = new ArrayList<>();
    }
    
    public void addNum(int num) {
        array.add(num);
    }
    
    public double findMedian() {
        Collections.sort(array);
        int size = array.size();
        if(size % 2 == 0) {
            return (array.get(size/2) + array.get(size/2 - 1)) / 2.0;
        }
        else {
            return array.get(size / 2);
        }
    }
}

class MedianFinder {

    PriorityQueue<Integer>  minHeap;
    PriorityQueue<Integer> maxHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        // 始终保证minHeap里面元素要比maxHeap里面要多
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        if (maxHeap.size() > minHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (double)(minHeap.peek() + maxHeap.peek()) / 2;
        } else {
            return minHeap.peek();
        }
    }
}

 class MedianFinder {

    PriorityQueue<Integer>  minHeap;
    PriorityQueue<Integer> maxHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<>((i1, i2) -> i2 - i1);
    }
    
    public void addNum(int num) {
        // 始终保证minHeap里面元素要比maxHeap里面要多
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        if (maxHeap.size() > minHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (double)(minHeap.peek() + maxHeap.peek()) / 2;
        } else {
            return minHeap.peek();
        }
    }
}
