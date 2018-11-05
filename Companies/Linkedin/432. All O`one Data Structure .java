class AllOne {

    class Node {
        Node prev;
        Node next;
        List<String> keys;
        int count;
        public Node(int count, String key) {
            this.keys = new ArrayList<>();
            this.count = count;
            keys.add(key);
        }
    }
    private Node head;
    private Node tail;
    private Map<String, Node> map;
    private Node cur;
    /** Initialize your data structure here. */
    public AllOne() {
        head = null;
        tail = null;
        map = new HashMap<>();
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (tail == null) {
            cur = new Node(1, key);
            head = cur;
            tail = cur;
            map.put(key, cur);
        } else if (!map.containsKey(key)) {
            if (tail.count == 1) {
                tail.keys.add(key);
                map.put(key, tail);
            } else {
                cur = new Node(1, key);
                cur.prev = tail;
                tail.next = cur;
                tail = cur;
                map.put(key, cur);
            }
        } else {
            cur = map.get(key);
            if (cur.prev != null) {
                if (cur.prev.count == cur.count + 1) {
                    cur.prev.keys.add(key);
                    cur.keys.remove(key);
                    map.put(key, cur.prev);
                    checkEmpty(cur);
                } else {
                    Node node = new Node(cur.count + 1, key);
                    node.prev = cur.prev;
                    node.next = cur;
                    node.prev.next = node;
                    cur.prev = node;
                    cur.keys.remove(key);
                    map.put(key, node);
                    checkEmpty(cur);
                }
            } else {
                head = new Node(cur.count + 1, key);
                head.next = cur;
                cur.prev = head;
                cur.keys.remove(key);
                map.put(key, head);
                checkEmpty(cur);
            }
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (head == null || !map.containsKey(key)) {
            return;
        }
        cur = map.get(key);
        if (cur.next != null) {
            if (cur.next.count == cur.count - 1) {
                cur.next.keys.add(key);
                cur.keys.remove(key);
                map.put(key, cur.next);
                checkEmpty(cur);
            } else {
                Node node = new Node(cur.count - 1, key);
                node.next = cur.next;
                cur.next.prev = node;
                node.prev = cur;
                cur.next = node;
                cur.keys.remove(key);
                map.put(key, node);
                checkEmpty(cur);
            }
        } else {
            if (cur.count == 1) {
                cur.keys.remove(key);
                map.remove(key);
                checkEmpty(cur);
            } else {
                tail = new Node(cur.count - 1, key);
                tail.prev = cur;
                cur.next = tail;
                cur.keys.remove(key);
                map.put(key, tail);
                checkEmpty(cur);
            }
        }
    }
    
    // to check whether the node should be delete because the keyList is empty.
    private void checkEmpty(Node node) {
        if (node.keys.size() != 0) {
            return;
        }
        if (node.prev == null && node.next == null) {
            head = null;
            tail = null;
        } else if (node.prev == null && node.next != null) {
            head = node.next;
            head.prev = null;
        } else if (node.prev != null && node.next == null) {
            tail = node.prev;
            tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (head == null) {
            return "";
        } else {
            return head.keys.get(0);
        }
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (tail == null) {
            return "";
        } else {
            return tail.keys.get(0);
        }
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */