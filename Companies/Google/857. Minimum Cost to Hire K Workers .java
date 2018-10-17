class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        double[][] workers = new double[wage.length][2];
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < wage.length; i++) {
            workers[i] = new double[]{(double)wage[i] / quality[i], quality[i]};
        }
        Arrays.sort(workers, (a, b) -> {
            if (a[0] == b[0]) {
                return 0;
            } else if (a[0] > b[0]) {
                return 1;
            } else {
                return -1;
            }
        });
        double res = Double.MAX_VALUE;
        double sum = 0;
        for (int i = 0; i < workers.length; i++) {
            pq.offer(workers[i][1]);
            sum += workers[i][1];
            if (pq.size() > K) {
                sum -= pq.poll();
            }
            if (pq.size() == K) {
                res = Math.min(res, sum * workers[i][0]);
            }
        }
        return res;
    }
}