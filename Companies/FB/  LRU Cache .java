class LRUCache {

    class Node {
        Node pre;
        Node next;
        int key;
        int value;
        public Node (int key, int value) {
            this.key = key;
            this.value = value;
            pre = null;
            next = null;
        }
    }
    Node head;
    Node tail;
    int length;
    int capacity;
    HashMap<Integer, Node> map;
    public LRUCache(int capacity) {
        head = null;
        tail = null;
        map = new HashMap<>();
        length = 0;
        this.capacity = capacity;
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
            map.put(key, node);
            setHead(node);
        } else {
            if (length < capacity) {
                Node node = new Node(key, value);
                setHead(node);
                length++;
                map.put(key, node);
            } else {
                Node node = new Node(key, value);
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
            tail = head;
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