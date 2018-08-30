class Solution {
    public int nthUglyNumber(int n) {
        Queue<Integer> q2 = new LinkedList<>();
        Queue<Integer> q3 = new LinkedList<>();
        Queue<Integer> q5 = new LinkedList<>();
        q2.offer(2);
        q3.offer(3);
        q5.offer(5);
        int count = 1;
        int res = 1;
        while (count != n) {
            int min = Math.min(q2.peek(), Math.min(q3.peek(), q5.peek()));
            if (min == q2.peek()) {
                q2.poll();
            } else if (min == q3.peek()) {
                q3.poll();
            } else {
                q5.poll();
            }
            if (min != res) {
                count++;
                res = min;
                q2.offer(2 * min);
                q3.offer(3 * min);
                q5.offer(5 * min);
            }
        }
        return res;
    }
}


class Solution {
    public int nthUglyNumber(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.offer((long)1);
        long res = 0;
        while (n-- > 0) {
            while (pq.peek() == res) {
                pq.poll();
            }
            res = pq.poll();
            pq.offer(res * 2);
            pq.offer(res * 3);
            pq.offer(res * 5);
        }
        return (int)res;
    }
}