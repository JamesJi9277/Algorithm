class RangeModule {

    Set<Integer> set;
    public RangeModule() {
        set = new HashSet();
    }
    
    public void addRange(int left, int right) {
        for (int i = left; i < right; i++) {
            set.add(i);
        }
    }
    
    public boolean queryRange(int left, int right) {
        for (int i = left; i < right; i++) {
            if (!set.contains(i)) {
                return false;
            }
        }
        return true;
    }
    
    public void removeRange(int left, int right) {
        for (int i = left; i < right; i++) {
            set.remove(i);
        }
    }
}

class RangeModule {
    
    TreeMap<Integer, Integer> ranges;
    
    public RangeModule() {
        ranges = new TreeMap<>();
    }
    
    public void addRange(int left, int right) {
        Integer previousIdx = ranges.floorKey(left);
        if (previousIdx != null && ranges.get(previousIdx) >= left) {
            left = Math.min(previousIdx, left);
            right = Math.max(ranges.get(previousIdx), right);
            ranges.remove(previousIdx);
        }
        
        Integer postIdx = ranges.ceilingKey(left);
        while(postIdx != null && postIdx <= right) {
            right = Math.max(ranges.get(postIdx), right);
            ranges.remove(postIdx);
            postIdx = ranges.ceilingKey(left);
        }
        ranges.put(left, right);
    }
    
    public boolean queryRange(int left, int right) {
        Integer previousIdx = ranges.floorKey(left);
        if (previousIdx == null) return false;
        if (ranges.get(previousIdx) >= right) return true;
        return false;
    }
    
    public void removeRange(int left, int right) {
        Integer previousKey = ranges.floorKey(left);
        if (previousKey != null && left < ranges.get(previousKey)) {
            int previousValue = ranges.get(previousKey);
            ranges.remove(previousKey);
            if (previousKey < left) ranges.put(previousKey, left);
            if (right < previousValue) ranges.put(right, previousValue);
        }
        Integer postKey = ranges.ceilingKey(left);
        while (postKey != null && right > postKey) {
            if (right >= ranges.get(postKey)) ranges.remove(postKey);
            else {
                Integer postValue = ranges.get(postKey);
                ranges.remove(postKey);
                ranges.put(right, postValue);
            }
            postKey = ranges.ceilingKey(left);
        }
    }
}