
class LRUCache {

    class Node {
    int key;
    int val;
    Node pre;
    Node next;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        pre = null;
        next = null;
        }
    }
    
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int length;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
        head = null;
        tail = null;
        length = 0;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        removeNode(node);
        setHead(node);
        
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            node.val = value;
            map.put(key, node);
            setHead(node);
        } else {
            if (length < capacity) {
                Node node = new Node(key, value);
                setHead(node);
                map.put(key, node);
                length++;
            } else {
                Node node = new Node(key, value);
                map.remove(tail.key);
                tail = tail.pre;
                if (tail != null) {
                    tail.next = null;
                }
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
        // 这一步很重要
        if (tail == null) {
            tail = node;
        }
    }
    
    private void removeNode(Node node) {
        Node cur = node;
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