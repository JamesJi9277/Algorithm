class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node() {
            
        }
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    Node head;
    Node tail;
    int capacity;
    int length;
    Map<Integer, Node> map;
    public LRUCache(int capacity) {
        head = null;
        tail = null;
        this.capacity = capacity;
        length = 0;
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
            removeNode(node);
            node.value = value;
            setHead(node);
            map.put(key, node);
        } else {
            if (length < capacity) {
                Node node = new Node(key, value);
                length++;
                setHead(node);
                map.put(key, node);
            } else {
                map.remove(tail.key);
                removeNode(tail);
                Node node = new Node(key, value);
                setHead(node);
                map.put(key, node);
            }
        }
    }
    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        if (prev != null) {
            prev.next = next;
        } else {
            head = next;
        }
        if (next != null) {
            next.prev = prev;
        } else {
            tail = prev;
        }
    }
    private void setHead(Node node) {
        node.prev = null;
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = node;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */