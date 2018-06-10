class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return people;
        }
        List<int[]> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            } else {
                return a[1] - b[1];
            }
        });
        for (int[] p : people) {
            pq.offer(p);
        }
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            res.add(p[1], p);
        }
        return (int[][]) res.toArray(new int[0][]);
    }
}