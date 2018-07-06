class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0) {
            return 0;
        }
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int distance = getDistance(points[i], points[j]);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getKey() > 0) {
                    int temp = entry.getValue();
                    res += temp * (temp - 1);
                }
            }
            map.clear();
        }
        return res;
    }
    private int getDistance(int[] a, int[] b) {
    int dx = a[0] - b[0];
    int dy = a[1] - b[1];
    
    return dx*dx + dy*dy;
}
}
