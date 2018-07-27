class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses < 0 || prerequisites == null) {
            return null;
        }
        HashMap<Integer, List<Integer>> map = initialGraph(numCourses);
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for (int[] edge : prerequisites) {
            map.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            list.add(temp);
            for (int i : map.get(temp)) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            }
        }
        if (list.size() != numCourses) {
            return new int[0];
        } else {
            return transform(list);
        }
    }
    private HashMap<Integer, List<Integer>> initialGraph(int n) {
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<Integer>());
        }
        return map;
    }
    private int[] transform(List<Integer> list) {
        int[] res = new int[list.size()];
        int index = 0;
        for (int i : list) {
            res[index++] = i;
        }
        return res;
    }
}