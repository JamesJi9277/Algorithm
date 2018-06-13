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
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, new IntervalComp());
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start) {
                return false;
            }
        }
        return true;
    }
}
class IntervalComp implements Comparator<Interval> {
    public int compare(Interval v1, Interval v2) {
        if (v1.start == v2.start) {
            return v1.end - v2.end;
        } else {
            return v1.start - v2.start;
        }
    }
}