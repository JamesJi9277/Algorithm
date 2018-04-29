class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 0) {
            return false;
        }
        int numNode = 0;
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>>();
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<Integer>());
        }
        for (int[] edge : prerequisites) {
            indegree[edge[1]]++;
            graph.get(edge[0]).add(edge[1]);
        }
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            numNode++;
            for (int i : graph.get(temp)) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            }
        }
        return numNode == numCourses;
    }
}