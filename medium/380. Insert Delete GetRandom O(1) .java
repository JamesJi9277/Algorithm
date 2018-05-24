class RandomizedSet {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private int index = 0;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<Integer, Integer>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        map.put(val, index);
        list.add(val);   
        index++;
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        int loc = map.get(val);
        map.put(list.get(list.size()-1), loc);
        list.set(loc, list.get(list.size()-1));
        list.remove(list.size()-1);
        map.remove(val);
        index--;
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int size = list.size();
        int count = new Random().nextInt(size);
        return list.get(count);
    }
}