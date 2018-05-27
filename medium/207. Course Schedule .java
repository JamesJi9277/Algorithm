class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || numCourses < 0) {
            return false;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<Integer>());
        }
        for (int[] edge : prerequisites) {
            map.get(edge[0]).add(edge[1]);
            
            indegree[edge[1]]++;
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            count++;
            for (int i : map.get(temp)) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            }
        }
        return count == numCourses;
    }
}