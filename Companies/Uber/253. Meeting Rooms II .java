class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a, b) -> (a.start - b.start));
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> (a.end - b.end));
        for (Interval i : intervals) {
            if (!pq.isEmpty() && pq.peek().end <= i.start) {
                Interval temp = pq.poll();
                temp.end = i.end;
                pq.offer(temp);
            } else {
                pq.offer(i);
            }
        }
        return pq.size();
    }
}