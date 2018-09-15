class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            int sameX = 1;
            int samePos = 0;
            Map<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    samePos++;
                }
                if (points[i].x == points[j].x) {
                    sameX++;
                    continue;
                }
                double k = (double)(points[i].y - points[j].y) / (double)(points[i].x - points[j].x);
                map.put(k, map.getOrDefault(k, 1) + 1);
                max = Math.max(max, map.get(k) + samePos);
            }
            max = Math.max(max, sameX);
        }
        return max;
    }
}