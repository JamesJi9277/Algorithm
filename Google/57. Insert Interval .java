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
        intervals.add(newInterval);
        return merge(intervals);
    }
    private List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> {
            if (a.start != b.start) {
                return a.start - b.start;
            } else {
                return a.end - b.end;
            }
        });
        List<Interval> res = new ArrayList<Interval>();
        for (Interval i : intervals) {
            if (res.size() == 0) {
                res.add(i);
            } else if (res.get(res.size() - 1).end < i.start) {
                res.add(i);
            } else {
                res.get(res.size() - 1).end = Math.max(i.end, res.get(res.size() - 1).end);
            }
        }
        return res;
    }
}