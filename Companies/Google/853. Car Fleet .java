class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < position.length; i++) {
            map.put(position[i], speed[i]);
        }
        Arrays.sort(position);
        int count = 0;
        for (int i = position.length - 1; i >= 0; i--) {
            double time = (double)(target - position[i]) / map.get(position[i]);
            if (pq.isEmpty()) {
                pq.offer(time);
                count++;
            } else if (time <= pq.peek()) {
                continue;
            } else if (time > pq.peek()) {
                count++;
                pq.offer(time);
            }
        }
        return count;
    }
}