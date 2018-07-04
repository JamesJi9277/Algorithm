class Solution {
    class Node {
        String node;
        double weight;
        Node(String n, double w) {
            node = n;
            weight = w;
        }
    }
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        //preprocessing the equations and values, to construct a map
        Map<String, List<Node>> valuePairs = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] e = equations[i];
            //for every equation
            valuePairs.putIfAbsent(e[0], new ArrayList<>());
            valuePairs.putIfAbsent(e[1], new ArrayList<>());
            valuePairs.get(e[0]).add(new Node(e[1], values[i]));
            valuePairs.get(e[1]).add(new Node(e[0], 1 / values[i]));    
        }
        
        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] q = queries[i];
            result[i] = DFS(valuePairs, q[0], q[1], new HashSet<String>(), 1.0);
        }
        return result;
    }
    
    private double DFS(Map<String, List<Node>> valuePairs, String start, String end, Set<String> visited, double cur) {
        //base: if start or end do not exist
        if (!valuePairs.containsKey(start) || !valuePairs.containsKey(end)) {
            return -1.0;
        }
        //base: if we have already visited the start
        if (visited.contains(start)) {
            return -1.0;
        }
        //basecase: if start == end
        if (start.equals(end)) {
            return cur;
        }
        //recursion rule
        visited.add(start);
        List<Node> neighbors = valuePairs.get(start);
        for (Node n : neighbors) {
            double tmp = DFS(valuePairs, n.node, end, visited, cur * n.weight);
            if (tmp >= 0) {
                return tmp;
            }
        }
        visited.remove(start);
        return -1.0;
        
    }
}

class Solution {
    class Node {
        String node;
        double weight;
        public Node (String node, double weight) {
            this.node = node;
            this.weight = weight;
        }
    }
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<Node>> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] e = equations[i];
            map.putIfAbsent(e[0], new ArrayList<Node>());
            map.putIfAbsent(e[1], new ArrayList<Node>());
            map.get(e[0]).add(new Node(e[1], values[i]));
            map.get(e[1]).add(new Node(e[0], 1 / values[i]));
        }
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = dfs(map, queries[i][0], queries[i][1], new HashSet<String>(), 1.0);
        }
        return res;
    }
    private double dfs(Map<String, List<Node>> map, String start, String end, Set<String> visited, double cur) {
        if (!map.containsKey(start) || !map.containsKey(end)) {
            return -1.0;
        }
        if (visited.contains(start)) {
            return -1.0;
        }
        if (start.equals(end)) {
            return cur;
        }
        visited.add(start);
        for (Node node : map.get(start)) {
            double temp = dfs(map, node.node, end, visited, cur * node.weight);
            // 保证不是-1.0
            if (temp != -1.0) {
                return temp;
            }
        }
        visited.remove(start);
        return -1.0;
    }
}