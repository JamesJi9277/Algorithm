class MaxStack {

    /** initialize your data structure here. */
    Stack<Integer> stack;
    PriorityQueue<Integer> pq;
    public MaxStack() {
        stack = new Stack<>();
        pq = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void push(int x) {
        stack.push(x);
        pq.offer(x);
    }
    
    public int pop() {
        int x = stack.pop();
        pq.remove(x);
        return x;
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return pq.peek();
    }
    
    public int popMax() {
        int x = pq.poll();
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty() && stack.peek() != x) {
            temp.push(stack.pop());
        }
        stack.pop();
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        return x;
    }
}