class Solution {
    public int[] findOrder(int numCourses, int[][] pres) {
        if (pres == null) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<Integer>());
            indegree.put(i, 0);
        }
        for (int[] pre : pres) {
            map.get(pre[1]).add(pre[0]);
            indegree.put(pre[0], indegree.get(pre[0]) + 1);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int temp = queue.poll();
                res.add(temp);
                for (int neighbor : map.get(temp)) {
                    indegree.put(neighbor, indegree.get(neighbor) - 1);
                    if (indegree.get(neighbor) == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        if (res.size() == numCourses) {
            return transform(res);
        } else {
            return new int[0];
        }
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