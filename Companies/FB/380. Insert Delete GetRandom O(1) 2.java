class RandomizedSet {

    List<Integer> list;
    int index;
    Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        index = 0;
        map = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res = false;
        if (map.containsKey(val)) {
            return res;
        }
        res = true;
        map.put(val, index++);
        list.add(val);
        return res;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        if (list.get(list.size() - 1) == val) {
            list.remove(list.size() - 1);
            index--;
            map.remove(val);
        } else {
            int lastEle = list.get(list.size() - 1);
            int replaceIndex = map.get(val);
            list.set(replaceIndex, lastEle);
            map.remove(val);
            map.put(lastEle, replaceIndex);
            index--;
        }
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(index));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */