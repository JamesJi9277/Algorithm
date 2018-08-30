class Solution {
    public int scheduleCourse(int[][] courses) {
        if (courses == null || courses.length == 0 || courses[0].length == 0) {
            return 0;
        }
        // sort based on due time
        Arrays.sort(courses, (a, b) -> (a[1] - b[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int time = 0;
        for (int[] c : courses) {
            time += c[0];
            pq.offer(c[0]);
            if (time > c[1]) {
                time -= pq.poll();
            }
        }
        return pq.size();
    }
}