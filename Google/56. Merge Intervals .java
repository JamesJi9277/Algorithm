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
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return intervals;
        }
        List<Interval> res = new ArrayList<Interval>();
        Collections.sort(intervals, new Comp());
        for (Interval interval : intervals) {
            if (res.size() == 0) {
                res.add(interval);
            }
            if (res.get(res.size() - 1).end < interval.start) {
                res.add(interval);
            } else if (res.get(res.size() - 1).end >= interval.start) {
                res.get(res.size() - 1).end = Math.max(res.get(res.size() - 1).end, interval.end);
            }
        }
        return res;
    }
}
class Comp implements Comparator<Interval> {
    @Override
    public int compare(Interval i1, Interval i2) {
        if (i1.start == i2.start) {
            return i1.end - i2.end;
        } else {
            return i1.start - i2.start;
        }
    }
}