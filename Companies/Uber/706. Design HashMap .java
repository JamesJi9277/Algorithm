class MyHashMap {

    class Node {
        int key;
        int value;
        Node next;
        public Node() {
            this.next = null;
        }
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    /** Initialize your data structure here. */
    int capacity;
    Node[] array;
    public MyHashMap() {
        this.capacity = 1000;
        this.array = new Node[capacity];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key % capacity;
        if (array[index] == null) {
            Node node = new Node(key, value);
            array[index] = node;
        } else {
            // support add is O1
            Node temp = array[index];
            Node node = new Node(key, value);
            node.next = temp;
            array[index] = node;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key % capacity;
        if (array[index] == null) {
            return -1;
        } else {
            Node temp = array[index];
            while (temp != null) {
                if (temp.key == key) {
                    return temp.value;
                } else {
                    temp = temp.next;
                }
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key % capacity;
        if (array[index] == null) {
            return;
        }
        Node head = array[index];
        Node dummy = new Node(0, 0);
        dummy.next = head;
        Node temp = dummy;
        while (temp.next != null) {
            if (temp.next.key == key) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        array[index] = dummy.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */