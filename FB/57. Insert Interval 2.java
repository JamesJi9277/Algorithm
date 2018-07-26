/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        int left = newInterval.start;
        int right = newInterval.end;
        for (Interval i : intervals) {
            if (i.end < left) {
                res.add(i);
            } else if (i.start > right) {
                res.add(new Interval(left, right));
                left = i.start;
                right = i.end;
            } else {
                left = Math.min(left, i.start);
                right = Math.max(right, i.end);
            }
        }
        res.add(new Interval(left, right));
        return res;
    }
}