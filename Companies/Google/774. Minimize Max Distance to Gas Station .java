class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        if (stations == null || stations.length == 0) {
            return 0.0;
        }
        double start = 0;
        double end = stations[stations.length - 1] - stations[0];
        while (start + 1e-6 < end) {
            double mid = start + (end - start) / 2;
            int count = 0;
            for (int i = 0; i < stations.length - 1; i++) {
                count += (int)(Math.ceil((stations[i + 1] - stations[i]) / mid) - 1);
            }
            if (count > K) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
先枚举距离，然后再进行对当前距离的插入个数的统计
再根据情况左右移动