class MyCalendarTwo {
    class Interval {
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    private List<Interval> booked;
    private List<Interval> overlap;
    public MyCalendarTwo() {
        booked = new ArrayList<>();
        overlap = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for (Interval i : overlap) {
            if (Math.max(i.start, start) < Math.min(end, i.end)) {
                return false;
            }
        }
        for (Interval i : booked) {
            int start1 = Math.max(i.start, start);
            int end1 = Math.min(i.end, end);
            if (start1 < end1) {
                overlap.add(new Interval(start1, end1));
            }
    
        }
        booked.add(new Interval(start, end));
        return true;
    }
}