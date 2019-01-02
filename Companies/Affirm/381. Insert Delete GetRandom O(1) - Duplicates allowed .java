class RandomizedCollection {

    List<Integer> list;
    Random random;
    Map<Integer, List<Integer>> map;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        random = new Random();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            map.get(val).add(list.size());
            list.add(val);
            return false;
        } else {
            map.put(val, new ArrayList<Integer>());
            map.get(val).add(list.size());
            list.add(val);
            return true;
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        List<Integer> temp = map.get(val);
        int loc = temp.get(temp.size() - 1);
        if (loc != list.size() - 1) {
            int lastEle = list.get(list.size() - 1);
            map.get(lastEle).remove(new Integer(list.size() - 1));
            map.get(lastEle).add(loc);
            list.set(loc, lastEle);
            list.remove(list.size() - 1);
            temp.remove(temp.size() - 1);
            map.put(val, temp);
        } else {
            map.get(val).remove(new Integer(loc));
            list.remove(loc);
        }
        if (map.get(val).isEmpty()) {
            map.remove(val);
        }
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */