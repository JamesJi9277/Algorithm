class MyHashMap {

    class Node {
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            pre = null;
            next = null;
        }
    }
    /** Initialize your data structure here. */
    int capacity = 1000;
    Node[] nums;
    public MyHashMap() {
        nums = new Node[capacity];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key % capacity;
        Node node = new Node(key, value);
        if (nums[index] == null) {
            nums[index] = node;
        } else {
            Node head = nums[index];
            head.pre = node;
            node.next = head;
            nums[index] = node;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key % capacity;
        Node node = nums[index];
        while (node != null && node.key != key) {
            node = node.next;
        }
        if (node == null) {
            return -1;
        }
        return node.value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key % capacity;
        Node node = nums[index];
        Node dummy = new Node(0, 0);
        dummy.next = node;
        Node runner = dummy;
        while (runner.next != null) {
            if (runner.next.key == key) {
                runner.next = runner.next.next;
            } else {
                runner = runner.next;
            }
        }
        nums[index] = dummy.next;
    }
}