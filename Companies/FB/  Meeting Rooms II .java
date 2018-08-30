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
        Arrays.sort(intervals, (a, b) -> (a.start - b.start));
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> (a.end - b.end));
        for (Interval i : intervals) {
            if (pq.isEmpty()) {
                pq.offer(i);
            } else {
                Interval temp = pq.poll();
                if (temp.end <= i.start) {
                    temp.end = i.end;
                } else {
                    pq.offer(i);
                }
                pq.offer(temp);
            }
        }
        return pq.size();
    }
}