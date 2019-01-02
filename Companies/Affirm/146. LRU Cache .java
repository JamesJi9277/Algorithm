// insert O1 can be linkedlist
// get O1 needs hashmap
// delete O1 needs doubly linked list
class LRUCache {

    Map<Integer, Node> map;
    int capacity;
    int size;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.size = 0;
        this.head = null;
        this.tail = null;
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
            Node node = new Node(key, value);
            map.put(key, node);
            if (size == capacity) {
                map.remove(tail.key);
                removeNode(tail);
                setHead(node);
            } else {
                setHead(node);
                size++;
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
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;
        }
    }
}
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
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */