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

class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, String> parent = new HashMap<>();
        Map<String, Double> val = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            String s1 = equations[i][0];
            String s2 = equations[i][1];
            double value = values[i];
            parent.putIfAbsent(s1, s1);
            parent.putIfAbsent(s2, s2);
            val.putIfAbsent(s1, 1.0);
            val.putIfAbsent(s2, 1.0);
            String root1 = findRoot(parent, val, s1);
            String root2 = findRoot(parent, val, s2);
            parent.put(root1, root2);
            double val1 = getDistance(parent, val, s1);
            double val2 = getDistance(parent, val, s2);
            val.put(root1, val2 * value / val1);
        }
        double[] res = new double[queries.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < queries.length; i++) {
            String s1 = queries[i][0];
            String s2 = queries[i][1];
            if (!parent.containsKey(s1) || !parent.containsKey(s2)) {
                continue;
            }
            String root1 = findRoot(parent, val, s1);
            String root2 = findRoot(parent, val, s2);
            if (root1.equals(root2)) {
                res[i] = getDistance(parent, val, s1) / getDistance(parent, val, s2);
            }
        }
        return res;
    }
    private String findRoot(Map<String, String> parent, Map<String, Double> val, String s) {
        while (!s.equals(parent.get(s))) {
            double val1 = val.get(s);
            double val2 = val.get(parent.get(s));
            parent.put(s, parent.get(parent.get(s)));
            val.put(s, val1 * val2);
            s = parent.get(s);
        }
        return s;
    }
    private double getDistance(Map<String, String> parent, Map<String, Double> val, String s) {
        double res= 1.0;
        while (!s.equals(parent.get(s))) {
            res *= val.get(s);
            s = parent.get(s);
        }
        return res;
    }
}