class MyCalendar {

    TreeMap<Integer, Integer> map;
    public MyCalendar() {
        map = new TreeMap<Integer, Integer>();
    }
    
    public boolean book(int start, int end) {
        if (start > end) {
            return false;
        }
        Integer floor = map.floorKey(start);
        if (floor != null && map.get(floor) > start) {
            return false;
        }
        Integer ceiling = map.ceilingKey(start);
        if (ceiling != null && ceiling < end) {
            return false;
        }
        map.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */

// naive way
class MyCalendar {

    int[] booked;
    public MyCalendar() {
        booked = new int[10000000002];
    }
    
    public boolean book(int start, int end) {
        if (end < start) {
            return false;
        }
        for (int i = start; i <= end; i++) {
            if (i != start && booked[i] == 1) {
                return false;
            }
            booked[i] = 1;
        }
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */




 