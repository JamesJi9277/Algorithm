class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int left = newInterval.start;
        int right = newInterval.end;
        for (Interval i : intervals) {
            int start = i.start;
            int end = i.end;
            if (start > right) {
                res.add(new Interval(left, right));
                left = start;
                right = end;
            } else if (end < left) {
                res.add(i);
            } else {
                left = Math.min(left, start);
                right = Math.max(right, end);
            }
        }
        res.add(new Interval(left, right));
        return res;
    }
}