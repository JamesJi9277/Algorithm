class Solution {
    class Node {
        String key;
        double value;
        public Node() {
            
        }
        public Node(String key, double value) {
            this.key = key;
            this.value = value;
        }
    }
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<Node>> map = new HashMap<>();
        int index = 0;
        for (String[] e : equations) {
            map.putIfAbsent(e[0], new ArrayList<Node>());
            map.putIfAbsent(e[1], new ArrayList<Node>());
            map.get(e[0]).add(new Node(e[1], values[index]));
            map.get(e[1]).add(new Node(e[0], 1 / values[index++]));
        }
        double[] res = new double[queries.length];
        index = 0;
        for (String[] q : queries) {
            res[index++] = dfs(map, q[0], q[1], new HashSet<String>(), 1.0);
        }
        return res;
    }
    private double dfs(Map<String, List<Node>> map, String start, String end, HashSet<String> visited, double value) {
        if (!map.containsKey(start) || !map.containsKey(end)) {
            return -1.0;
        }
        if (visited.contains(start)) {
            return -1.0;
        }
        if (start.equals(end)) {
            return value;
        }
        visited.add(start);
        for (Node node : map.get(start)) {
            double temp = dfs(map, node.key, end, visited, value * node.value);
            if (temp > 0) {
                return temp;
            }
        }
        visited.remove(start);
        return -1.0;
    }
}