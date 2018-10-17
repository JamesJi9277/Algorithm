time nlogn
class MyCalendar {

    TreeMap<Integer, Integer> map;
    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        if (start > end) {
            return false;
        }
        // 小于start里面最大的
        // 如果有的话，那么这个区间的结尾肯定不能够超过start
        // 可以等于
        Integer floor = map.floorKey(start);
        if (floor != null && map.get(floor) > start) {
            return false;
        }
        // 大于start里面最小的
        // 如果有的话，那么这个start必须要比end要大于等于
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
On2 On
class MyCalendar {

    class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    List<Interval> list;
    public MyCalendar() {
        list = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        Interval interval = new Interval(start, end);
        if (check(list, interval)) {
            list.add(interval);
            return true;
        } else {
            return false;
        }
    }
    private boolean check(List<Interval> list, Interval interval) {
        for (Interval i : list) {
            if (Math.max(i.start, interval.start) < Math.min(i.end, interval.end)) {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */



 