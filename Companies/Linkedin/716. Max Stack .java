class MaxStack {
    
    class ListNode{
        int val;
        int max;
        ListNode next;
        ListNode prev;
        public ListNode(int val, int max){
            this.val = val;
            this.max = max;
        }
    }
    
    ListNode head;
    ListNode tail;

    /** initialize your data structure here. */
    public MaxStack() {
        head = new ListNode(Integer.MIN_VALUE, Integer.MIN_VALUE);
        tail = new ListNode(Integer.MAX_VALUE, Integer.MAX_VALUE);
        
        head.next = tail;
        tail.prev = head;
    }
    
    public void push(int x) {
        ListNode node = new ListNode(x, Math.max(x, tail.prev.max));
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        
    }
    
    public int pop() {
        ListNode node = tail.prev;
        
        node.prev.next = tail;
        tail.prev = node.prev;
        node.next = null;
        node.prev = null;
        
        return node.val;
    }
    
    public int top() {
        return tail.prev.val;
    }
    
    public int peekMax() {
        return tail.prev.max;
    }
    
    public int popMax() {
        int max = peekMax();
        ListNode cur = tail.prev;
        
        while(cur.val != max){
            cur = cur.prev;
        }
        
        ListNode update = cur.next;
        
        cur.prev.next = update;
        update.prev = cur.prev;
        cur.next = null;
        cur.prev = null;
        
        while(update != tail){
            update.max = Math.max(update.val, update.prev.max);
            update = update.next;
        }
        
        return max;
    }
}

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
