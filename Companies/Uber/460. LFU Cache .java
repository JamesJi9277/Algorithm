map is used to store key to frequency
freq map is used to store frequency to LinkedHashMap of key to value
public class LFUCache {

    int min;
    Map<Integer, Integer> map;
    Map<Integer, Map<Integer, Integer>> freq;
    int capacity;
    
    public LFUCache(int capacity) {
        
        min = 0;
        map = new HashMap();
        freq = new HashMap();
        this.capacity = capacity;
    }
    
    private int update(int key, int v)
    {
        //get frequency of key and freq map
        int count = map.get(key);
        Map<Integer, Integer> values = freq.get(count);
        
        //remove the key from values map
        int ans = values.remove(key);
        
        //values map is empty remove freq bucket and update min
        if(values.size() == 0)
        {
            if(min == count) min = count + 1;
            freq.remove(count);
        }
        
        count++;
        //create new freq bucket and add key and ans to its values
        if(!freq.containsKey(count))
            freq.put(count, new LinkedHashMap());
            
        freq.get(count).put(key, v == Integer.MIN_VALUE ? ans : v);
        map.put(key, count);
        
        return ans;
    }
    
    public int get(int key) {
        
        if(!map.containsKey(key) || capacity == 0) return -1;
        
        return update(key, Integer.MIN_VALUE);
    }
    
    public void put(int key, int value) {
        
        if(capacity == 0) return;
        
        if(map.containsKey(key))
        {
            update(key, value);
            return;
        }
        
        if(map.size() == capacity)
        {
            Map<Integer, Integer> values = freq.get(min);
            Integer firstKey = values.keySet().iterator().next();
            
            values.remove(firstKey);
        
            //values map is empty remove freq bucket
            if(values.size() == 0)
            {
                freq.remove(min);
            }   
            
            map.remove(firstKey);
        }
        
        //create new freq bucket and add key and value to its values
        if(!freq.containsKey(1))
            freq.put(1, new LinkedHashMap());
            
        freq.get(1).put(key, value);
        map.put(key, 1);
        min = 1;
    }
}