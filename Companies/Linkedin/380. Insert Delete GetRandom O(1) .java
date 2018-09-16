class RandomizedSet {

    List<Integer> list;
    Random random;
    Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        random = new Random();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        if (list.get(list.size() - 1) == val) {
            list.remove(list.size() - 1);
            map.remove(val);
        } else {
            int index = map.get(val);
            map.remove(val);
            list.set(index, list.get(list.size() - 1));
            map.put(list.get(list.size() - 1), index);
            list.remove(list.size() - 1);
        }
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}