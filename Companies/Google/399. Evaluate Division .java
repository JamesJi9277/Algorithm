class Solution {
    class Node {
        String key;
        double value;
        public Node (String key, Double value) {
            this.key = key;
            this.value = value;
        }
    }
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<Node>> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            String s1 = equations[i][0];
            String s2 = equations[i][1];
            double value = values[i];
            map.putIfAbsent(s1, new ArrayList<Node>());
            map.putIfAbsent(s2, new ArrayList<Node>());
            map.get(s1).add(new Node(s2, value));
            map.get(s2).add(new Node(s1, 1 / value));
        }
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String s1 = queries[i][0];
            String s2 = queries[i][1];
            res[i] = helper(s1, s2, map, new HashSet<String>(), 1.0);
        }
        return res;
    }
    private double helper(String start, String end, Map<String, List<Node>> map, Set<String> visited, double res) {
        if (!map.containsKey(start) || !map.containsKey(end) || !visited.add(start)) {
            return -1.0;
        }
        if (start.equals(end)) {
            return res;
        }
        for (Node n : map.get(start)) {
            double temp = helper(n.key, end, map, visited, res * n.value);
            if (temp > 0) {
                return temp;
            }
        }
        return -1;
    }
}

class Solution {
    class Pair {
        String key;
        double value;
        public Pair(String key, double value) {
            this.key = key;
            this.value = value;
        }
    }
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Pair> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String s1 = equations[i][0];
            String s2 = equations[i][1];
            double value = values[i];
            map.putIfAbsent(s1, new Pair(s1, 1.0));
            map.putIfAbsent(s2, new Pair(s2, 1.0));
            Pair root1 = findRoot(map, s1);
            Pair root2 = findRoot(map, s2);
            if (!root1.key.equals(root2.key)) {
                map.put(root1.key, new Pair(s2, value / root1.value));
            }
        }
        double[] res = new double[queries.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < res.length; i++) {
            String s1 = queries[i][0];
            String s2 = queries[i][1];
            if (!map.containsKey(s1) || !map.containsKey(s2)) {
                continue;
            }
            Pair root1 = findRoot(map, s1);
            Pair root2 = findRoot(map, s2);
            if (!root1.key.equals(root2.key)) {
                continue;
            }
            res[i] = root1.value / root2.value;
        }
        return res;
    }
    private Pair findRoot(Map<String, Pair> map, String s) {
        String temp = s;
        double res = 1.0;
        while (!s.equals(map.get(s).key)) {
            Pair p = map.get(s);
            res *= p.value;
            s = p.key;
        }
        map.put(temp, new Pair(s, res));
        return map.get(temp);
    }
}


class Solution {
    class Node {
        String key;
        double value;
        public Node(String key, double value) {
            this.key = key;
            this.value = value;
        }
    }
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Node> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String s1 = equations[i][0];
            String s2 = equations[i][1];
            double value = values[i];
            map.putIfAbsent(s1, new Node(s1, 1.0));
            map.putIfAbsent(s2, new Node(s2, 1.0));
            Node root1 = findRoot(map, s1);
            Node root2 = findRoot(map, s2);
            if (!root1.key.equals(root2.key)) {
                map.put(root1.key, new Node(root2.key, value * root2.value / root1.value));
            }
        }
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String s1 = queries[i][0];
            String s2 = queries[i][1];
            if (!map.containsKey(s1) || !map.containsKey(s2)) {
                res[i] = -1.0;
                continue;
            }
            Node root1 = findRoot(map, s1);
            Node root2 = findRoot(map, s2);
            if (!root1.key.equals(root2.key)) {
                res[i] = -1.0;
                continue;
            }
            res[i] = root1.value / root2.value;
        }
        return res;
    }
    private Node findRoot(Map<String, Node> map, String s) {
        String temp = s;
        double value = 1.0;
        while (!s.equals(map.get(s).key)) {
            Node n = map.get(s);
            value *= n.value;
            s = n.key;
        }
        map.put(temp, new Node(s, value));
        return map.get(temp);
    }
}