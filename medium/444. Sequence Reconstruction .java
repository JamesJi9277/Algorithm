class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        Map<Integer, Integer> indegree = new HashMap<Integer, Integer>();
        for (List<Integer> list : seqs) {
            for (int i = 0; i < list.size(); i++) {
                graph.putIfAbsent(list.get(i), new ArrayList<Integer>());
                indegree.putIfAbsent(list.get(i), 0);
                if (i > 0) {
                    graph.get(list.get(i - 1)).add(list.get(i));
                    indegree.put(list.get(i), indegree.get(list.get(i)) + 1);
                }
            }
        }
        //先简历去这个graph
        if (org.length != indegree.size()) {
            return false;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false; // must be unique
            }
            int cur = queue.poll();
            if (org[index++] != cur) {
                return false;
            }
            for (int neighbor : graph.get(cur)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return index == org.length;
    }
}

// second write
class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        Map<Integer, Integer> indegree = new HashMap<Integer, Integer>();
        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                graph.putIfAbsent(seq.get(i), new ArrayList<Integer>());
                indegree.putIfAbsent(seq.get(i), 0);
                if (i > 0) {
                    graph.get(seq.get(i - 1)).add(seq.get(i));
                    indegree.put(seq.get(i), indegree.get(seq.get(i)) + 1);
                }
            }
        }
        if (org.length != indegree.size()) {
            return false;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }
        int index = 0;
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false;
            }
            int temp = queue.poll();
            if (org[index++] != temp) {
                return false;
            }
            for (int neighbor : graph.get(temp)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return index == org.length;
    }
}