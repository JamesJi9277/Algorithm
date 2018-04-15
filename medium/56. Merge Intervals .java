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
        List<Interval> res = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            return res;
        }
        Comp comp = new Comp();
        Collections.sort(intervals, comp);
        res.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            if (res.get(res.size() - 1).end >= intervals.get(i).start) {
                res.get(res.size() - 1).end = Math.max(res.get(res.size() - 1).end, intervals.get(i).end);
            } else {
                res.add(intervals.get(i));
            }
        }
        return res;
    }
    private class Comp implements Comparator<Interval> {
        public int compare(Interval v1, Interval v2) {
            if (v1.start > v2.start) {
                return 1;
            } else if (v1.start < v2.start) {
                return -1;
            } else {
                return v1.end - v2.end;
            }
        }
    }
}