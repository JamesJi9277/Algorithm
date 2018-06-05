class MyCalendarTwo {

    TreeMap<Integer, Interval> map = new TreeMap<>();
    TreeMap<Integer, Interval> intersections = new TreeMap<>();
    public MyCalendarTwo() {

    }
    
    public boolean book(int start, int end) {
        if (hasIntersection(start, end)) {
            return false;
        }
        if (map.size() == 0) {
            map.put(start, new Interval(start, end));
            return true;
        }
        Integer preKey = map.floorKey(start);
        if (preKey != null && map.get(preKey).end > start) {
            intersections.put(start, new Interval(start, Math.min(end, map.get(preKey).end)));
            start = map.get(preKey).start;
            end = Math.max(end, map.get(preKey).end);
            map.remove(preKey);
        }
        
        Integer nextKey = map.higherKey(start);
        while(nextKey!=null && nextKey<end){
            
            intersections.put(nextKey,new Interval(nextKey,Math.min(end,map.get(nextKey).end)));
            end = Math.max(end,map.get(nextKey).end);
            map.remove(nextKey);
            
            nextKey = map.higherKey(start);
        }
        map.put(start,new Interval(start,end));
        return true;
    }
    private boolean hasIntersection(int start, int end) {
        Integer floor = intersections.floorKey(start);
        if (floor != null && intersections.get(floor).end > start) {
            return true;
        }
        Integer ceiling = intersections.ceilingKey(start);
        if (ceiling != null && intersections.get(ceiling).start < end) {
            return true;
        }
        return false;
    }
}

class Interval {
    int start;
    int end;
    public Interval() {};
    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */