class Solution {
    public int maxPoints(Point[] points) {
        int max = 0;
        if (points == null || points.length < 0) {
            return max;
        }
        for (int i = 0; i < points.length; i++) {
            int samePos = 0;
            int sameX = 1;
            HashMap<Double, Integer> map = new HashMap<>();
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
                double k = (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
                if (map.containsKey(k)) {
                    map.put(k, map.get(k) + 1);
                } else {
                    map.put(k, 2);
                }
                max = Math.max(max, map.get(k) + samePos);
            }
            max = Math.max(max, sameX);
        }
        return max;
    }
}
