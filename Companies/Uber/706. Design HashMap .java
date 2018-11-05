class MyHashMap {

    /** Initialize your data structure here. */
    class Node {
        int key;
        int value;
        //Node prev;
        Node next;
        public Node() {
            
        }
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            //prev = null;
            next = null;
        }
    }
    int size = 1000;
    Node[] array;
    public MyHashMap() {
        array = new Node[1000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key % size;
        Node node = new Node(key, value);
        if (array[index] == null) {
            array[index] = node;
        } else {
            Node temp = array[index];
            while (temp != null && temp.key != key) {
                temp = temp.next;
            }
            if (temp == null) {
                node.next = array[index];
                //array[index].prev = node;
                array[index] = node;
            } else {
                temp.value = value;
            }
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key % size;
        if (array[index] == null) {
            return -1;
        }
        Node head = array[index];
        while (head != null) {
            if (head.key == key) {
                return head.value;
            } else {
                head = head.next;
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key % size;
        if (array[index] == null) {
            return;
        }
        Node dummy = new Node();
        dummy.next = array[index];
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