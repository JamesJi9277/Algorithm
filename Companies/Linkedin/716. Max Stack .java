class MaxStack {

    /** initialize your data structure here. */
    Stack<Integer> stack1;
    Stack<Integer> stack;
    PriorityQueue<Integer> pq;
    public MaxStack() {
        stack = new Stack<>();
        stack1 = new Stack<>();
        pq = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void push(int x) {
        stack.push(x);
        pq.offer(x);
    }
    
    public int pop() {
        int temp = stack.pop();
        pq.remove(temp);
        return temp;
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return pq.peek();
    }
    
    public int popMax() {
        int temp = pq.poll();
        boolean seen = false;
        while (!stack.isEmpty()) {
            if (!seen && stack.peek() == temp) {
                stack.pop();
                seen = true;
            } else {
                stack1.push(stack.pop());
            }
        }
        while (!stack1.isEmpty()) {
            stack.push(stack1.pop());
        }
        return temp;
    }
}
