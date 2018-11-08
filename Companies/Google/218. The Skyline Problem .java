class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return res;
        }
        Point[] points = new Point[buildings.length * 2];
        int index = 0;
        for (int[] building : buildings) {
            Point point1 = new Point(building[0], building[2], true);
            Point point2 = new Point(building[1], building[2], false);
            points[index++] = point1;
            points[index++] = point2;
        }
        Arrays.sort(points);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.offer(0);
        int preMax = 0;
        for (Point p : points) {
            if (p.isStart) {
                pq.offer(p.height);
            } else {
                pq.remove(p.height);
            }
            int curMax = pq.peek();
            if (curMax != preMax) {
                res.add(new int[]{p.x, curMax});
                preMax = curMax;
            }
        }
        return res;
    }
    class Point implements Comparable<Point> {
        int x;
        int height;
        boolean isStart;
        public Point() {
            
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
            } else {
                        // first compare to x, start point
        // if two share same start, then with higher height comes first
        // if two share same end, then with lower heigh comes first
        // 目的是为了要让在同一点的max尽可能先保持在里面
                return (this.isStart ? -this.height : this.height) - (that.isStart ? -that.height : that.height);
            }
        }
    }
}

class Solution {
    class Node {
        int x;
        int height;
        boolean isStart;
        public Node(int x, int height, boolean isStart) {
            this.x = x;
            this.height = height;
            this.isStart = isStart;
        }
    }
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0) {
            return res;
        }
        List<Node> nodes = new ArrayList<>();
        for (int[] b : buildings) {
            Node n1 = new Node(b[0], b[2], true);
            Node n2 = new Node(b[1], b[2], false);
            nodes.add(n1);
            nodes.add(n2);
        }
        Collections.sort(nodes, (a, b) -> {
            if (a.x != b.x) {
                return a.x - b.x;
            } else {
                return (a.isStart ? -a.height : a.height) - (b.isStart ? -b.height : b.height);
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.offer(0);
        for (Node n : nodes) {
            int curMax = pq.peek();
            if (n.isStart) {
                pq.offer(n.height);
            } else {
                pq.remove(n.height);
            }
            if (curMax != pq.peek()) {
                curMax = pq.peek();
                res.add(new int[]{n.x, curMax});
            }
        }
        return res;
    }
}