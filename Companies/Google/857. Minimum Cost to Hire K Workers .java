class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        double[][] workers = new double[wage.length][2];
        for (int i = 0; i < wage.length; i++) {
            workers[i] = new double[]{(double)(wage[i]) / quality[i], (double)quality[i]};
        }
        // sort on xingjiabi
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        double res = Double.MAX_VALUE;
        double qSum = 0;
        for (int i = 0; i < workers.length; i++) {
            pq.offer(workers[i][1]);
            qSum += workers[i][1];
            if (pq.size() > K) {
                qSum -= pq.poll();
            }
            if (pq.size() == K) {
                res = Math.min(res, qSum * workers[i][0]);
            }
        }
        return res;
    }
}