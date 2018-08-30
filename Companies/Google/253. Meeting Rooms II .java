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
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) ->(a.start - b.start));
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>((a, b) -> a.end - b.end);
        for (Interval interval : intervals) {
            if (pq.isEmpty()) {
                pq.offer(interval);
            } else {
                Interval i = pq.poll();
                if (i.end <= interval.start) {
                    i.end = interval.end;
                } else {
                    pq.offer(interval);
                }
                pq.offer(i);
            }
        }
        return pq.size();
    }
}