class RandomizedSet {

    List<Integer> list;
    Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
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
            map.remove(val);
            list.remove(list.size() - 1);
        } else {
            int lastEle = list.get(list.size() - 1);
            list.set(map.get(val), lastEle);
            list.remove(list.size() - 1);
            map.put(lastEle, map.get(val));
            map.remove(val);
        }
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }
}