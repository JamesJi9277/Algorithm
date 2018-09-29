class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Double> map = new TreeMap<>();
        for (int i = 0; i < position.length; i++) {
            map.put(-position[i], (double)(target - position[i]) / speed[i]);
        }
        int res = 0;
        double cur = 0;
        for (Map.Entry<Integer, Double> entry : map.entrySet()) {
            if (entry.getValue() > cur) {
                cur = entry.getValue();
                res++;
            }
        }
        return res;
    }
}