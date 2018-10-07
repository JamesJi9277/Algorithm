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
        if (equations == null) {
            return null;
        }
        Map<String, List<Pair>> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            map.putIfAbsent(equations[i][0], new ArrayList<Pair>());
            map.putIfAbsent(equations[i][1], new ArrayList<Pair>());
            map.get(equations[i][0]).add(new Pair(equations[i][1], values[i]));
            map.get(equations[i][1]).add(new Pair(equations[i][0], 1 / values[i]));
        }
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = helper(map, queries[i][0], queries[i][1], new HashSet<String>(), 1.0);
        }
        return res;
    }
    private double helper(Map<String, List<Pair>> map, String start, String end, Set<String> visited, double cur) {
        if (!map.containsKey(start) || !map.containsKey(end)) {
            return -1.0;
        }
        if (!visited.add(start)) {
            return -1.0;
        }
        if (start.equals(end)) {
            return cur;
        }
        for (Pair p : map.get(start)) {
            double res = helper(map, p.key, end, visited, cur * p.value);
            if (res > 0) {
                return res;
            }
        }
        return -1.0;
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