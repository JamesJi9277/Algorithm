class LRUCache {

    class Node {
        Node pre;
        Node next;
        int key;
        int value;
        public Node() {
            this.pre = null;
            this.next = next;
        }
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.pre = null;
            this.next = null;
        }
    }
    Node head;
    Node tail;
    int capacity;
    int length;
    Map<Integer, Node> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        length = 0;
        head = null;
        tail = null;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        removeNode(node);
        setHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            map.put(key, node);
            removeNode(node);
            setHead(node);
        } else {
            if (length < capacity) {
                length++;
                Node node = new Node(key, value);
                map.put(key, node);
                setHead(node);
            } else {
                Node node = new Node(key, value);
                // so classic, need first update map before update tail
                // also common sense
                map.remove(tail.key);
                removeNode(tail);
                map.put(key, node);
                setHead(node);
            }
        }
    }
    private void setHead(Node node) {
        node.pre = null;
        node.next = head;
        if (head != null) {
            head.pre = node;
        }
        head = node;
        if (tail == null) {
            tail = node;
        }
    }
    
    private void removeNode(Node node) {
        Node pre = node.pre;
        Node next = node.next;
        if (pre != null) {
            pre.next = next;
        } else {
            head = next;
        }
        if (next != null) {
            next.pre = pre;
        } else {
            tail = pre;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */