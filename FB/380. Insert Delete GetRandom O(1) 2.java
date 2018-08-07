class RandomizedSet {

    Map<Integer, Integer> map;
    List<Integer> list;
    int index;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        index = 0;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, index++);
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int loc = map.get(val);
        // replace
        map.put(list.get(list.size() - 1), loc);
        map.remove(val);
        list.set(loc, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        index--;
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int count = new Random().nextInt(index);
        return list.get(count);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */


class RandomizedSet {

    Map<Integer, Integer> map;
    List<Integer> list;
    int index;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
        index = 0;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, index);
        index++;
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int targetIndex = map.get(val);
        map.put(list.get(list.size() - 1), targetIndex);
        map.remove(val);
        list.set(targetIndex, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        index--;
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(new Random().nextInt(index));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */