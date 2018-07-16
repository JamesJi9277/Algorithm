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
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }
        Collections.sort(intervals, (a, b) -> {
            if (a.start == b.start) {
                return a.end - b.end;
            } else {
                return a.start - b.start;
            }
        });
        for (Interval i : intervals) {
            if (res.isEmpty()) {
                res.add(i);
            } else if (i.start <= res.get(res.size() - 1).end) {
                res.get(res.size() - 1).end = Math.max(res.get(res.size() - 1).end, i.end);
            } else {
                res.add(i);
            }
        }
        return res;
    }
}