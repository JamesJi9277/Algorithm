class MyHashSet {

    HashMap<Integer, Integer> table;
    /** Initialize your data structure here. */
    public MyHashSet() {
        table = new HashMap<>();
    }
    
    public void add(int key) {
        table.put(key, table.getOrDefault(key, 0) + 1);
    }
    
    public void remove(int key) {
        if (table.containsKey(key)) {
            table.put(key, 0);
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return table.containsKey(key) && table.get(key) > 0;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */