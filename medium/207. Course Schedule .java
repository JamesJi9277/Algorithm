// initial steps must be done outside for loop
// for strange test case consideration 
// like 1 [], 3, [0, 1]
class Solution {
    public boolean canFinish(int numCourses, int[][] pres) {
        if (pres == null || numCourses < 0) {
            return false;
        }
        if (pres.length == 0) {
            return true;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            indegree.put(i, 0);
            map.put(i, new ArrayList<Integer>());
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int[] pre : pres) {
            map.get(pre[1]).add(pre[0]);
            indegree.put(pre[0], indegree.get(pre[0]) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int temp = queue.poll();
                count++;
                for (int neighbor : map.get(temp)) {
                    indegree.put(neighbor, indegree.get(neighbor) - 1);
                    if (indegree.get(neighbor) == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return count == numCourses;
    }
}