class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return res;
        }
        Point[] points = new Point[buildings.length * 2];
        int index = 0;
        for (int i = 0; i < buildings.length; i++) {
            int[] temp = buildings[i];
            Point p1 = new Point(temp[0], temp[2], true);
            Point p2 = new Point(temp[1], temp[2], false);
            points[index++] = p1;
            points[index++] = p2;
        }
        Arrays.sort(points);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.offer(0);
        int curMax = 0;
        for (Point p : points) {
            if (p.isStart) {
                pq.offer(p.height);
            } else {
                pq.remove(p.height);
            }
            int tempMax = pq.peek();
            if (curMax != tempMax) {
                curMax = tempMax;
                res.add(new int[]{p.x, tempMax});
            }
        }
        return res;
    }
    class Point implements Comparable<Point> {
        int x;
        int height;
        boolean isStart;
        public Point() {
            this.isStart = false;
        }
        public Point(int x, int height, boolean isStart) {
            this.x = x;
            this.height = height;
            this.isStart = isStart;
        }
        
        @Override
        public int compareTo(Point that) {
            if (this.x != that.x) {
                return this.x - that.x;
            } 
            return (this.isStart ? -this.height : this.height) - (that.isStart ? -that.height : that.height);
        }
    }
}