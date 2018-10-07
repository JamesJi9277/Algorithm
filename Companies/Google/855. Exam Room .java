class ExamRoom {

    class Interval {
        int start;
        int end;
        int length;
        public Interval(int start, int end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }
    }
    PriorityQueue<Interval> pq;
    int length;
    public ExamRoom(int N) {
        length = N;
        pq = new PriorityQueue<>((a, b) -> {
            if (a.length == b.length) {
                return a.start - b.start;
            } else {
                return b.length - a.length;
            }
        });
        pq.offer(new Interval(-1, length, length));
    }
    
    public int seat() {
        Interval temp = pq.poll();
        if (temp.start == -1) {
            pq.offer(new Interval(0, temp.end, temp.length - 1));
            return 0;
        } else if (temp.end == length) {
            pq.offer(new Interval(temp.start, temp.end - 1, temp.length - 1));
            return length - 1;
        } else {
            int mid = temp.start + (temp.end - temp.start) / 2;
            pq.offer(new Interval(temp.start, mid, (mid - temp.start) / 2));
            pq.offer(new Interval(mid, temp.end, (temp.end - mid) / 2));
            return mid;
        }
    }
    
    public void leave(int p) {
        Interval prev = null;
        Interval cur = null;
        for (Interval i : pq) {
            if (i.end == p) {
                prev = i;
            }
            if (i.start == p) {
                cur = i;
            }
        }
        if (prev == null && cur != null) {
            pq.remove(cur);
            pq.offer(new Interval(-1, cur.end, cur.end - cur.start));
        } else if (prev != null && cur == null) {
            pq.remove(prev);
            pq.offer(new Interval(prev.start, length, prev.end - prev.start));
        } else {
            pq.remove(prev);
            pq.remove(cur);
            if (prev.start == -1 || cur.end == length) {
                pq.offer(new Interval(prev.start, cur.end, cur.end - prev.start));
            } else {
                pq.offer(new Interval(prev.start, cur.end, (cur.end - prev.start) / 2));
            }
        }
    }
}