class Solution {
    public double minmaxGasDist(int[] stations, int k) {
        int count = 0;
        double left = 0;
        double right = stations[stations.length - 1] - stations[0];
        while (left + 1e-6 < right) {
            double mid = left + (right - left) / 2;
            count = 0;
            for (int i = 0; i < stations.length - 1; i++) {
                count += Math.ceil((stations[i + 1] - stations[i]) / mid) - 1;
            }
            if (count > k) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
}