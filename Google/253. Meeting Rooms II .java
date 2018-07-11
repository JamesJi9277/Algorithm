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
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(intervals.length, (a, b) -> (a.end - b.end));
        pq.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval temp = pq.poll();
            if (temp.end <= intervals[i].start) {
                temp.end = intervals[i].end;
            } else {
                pq.offer(intervals[i]);
            }
            pq.offer(temp);
        }
        
        return pq.size();
    }
}

class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int endIter = 0;
        int room = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (start[i] < end[endIter]) {
                room++;
            } else {
                endIter++;
            }
        }
        return room;
    }
}