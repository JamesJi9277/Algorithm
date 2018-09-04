class Solution {
    public boolean canFinish(int numCourses, int[][] pres) {
        if (pres == null) {
            return false;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<Integer>());
            indegree.put(i, 0);
        }
        for (int[] pre : pres) {
            map.get(pre[0]).add(pre[1]);
            indegree.put(pre[1], indegree.get(pre[1]) + 1);
        }
        Queue<Integer> queue = new LinkedList<>();
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