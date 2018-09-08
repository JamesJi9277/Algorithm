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
        int start = newInterval.start;
        int end = newInterval.end;
        for (Interval i : intervals) {
            int left = i.start;
            int right = i.end;
            if (right < start) {
                res.add(i);
            } else if (left > end) {
                res.add(new Interval(start, end));
                start = left;
                end = right;
            } else {
                start = Math.min(left, start);
                end = Math.max(right, end);
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}