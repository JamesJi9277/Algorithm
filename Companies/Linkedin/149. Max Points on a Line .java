class Solution {
    public int maxPoints(Point[] points) {
        int res = 0;
        if (points == null || points.length == 0) {
            return 0;
        }
        for (Point p : points) {
            int samePoint = 0;
            int sameX = 1;
            Map<Double, Integer> map = new HashMap<>();
            for (Point q : points) {
                if (p == q) {
                    continue;
                }
                if (p.x == q.x && p.y == q.y) {
                    samePoint++;
                }
                if (p.x == q.x) {
                    sameX++;
                    continue;
                }
                double k = (double)(p.x - q.x) / (double)(p.y - q.y);
                map.put(k, map.getOrDefault(k, 1) + 1);
                res = Math.max(res, map.get(k) + samePoint);
            }
            res = Math.max(res, sameX);
        }
        return res;
    }
}