class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int start = newInterval.start;
        int end = newInterval.end;
        for (Interval i : intervals) {
            int left = i.start;
            int right = i.end;
            if (right < start) {
                res.add(new Interval(left, right));
            } else if (left > end) {
                res.add(new Interval(start, end));
                start = left;
                end = right;
            } else {
                start = Math.min(start, left);
                end = Math.max(end, right);
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}