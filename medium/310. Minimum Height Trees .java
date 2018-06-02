class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<Integer>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        HashSet<Integer>[] neighbors = new HashSet[n];
        int[] degrees = new int[n];
        HashSet<Integer> isVisited = new HashSet<Integer>();
        List<Integer> leafs = new ArrayList<Integer>();
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            if (neighbors[a] == null) {
                neighbors[a] = new HashSet<Integer>();
            } 
                neighbors[a].add(b);
            
            if (neighbors[b] == null) {
                neighbors[b] = new HashSet<Integer>();
            } 
                neighbors[b].add(a);
            
            degrees[a]++;
            degrees[b]++;
        }
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] == 1) {
                leafs.add(i);
            }
        }
        while (isVisited.size() < n - 2) {
            List<Integer> nextLevel = new ArrayList<Integer>();
            for (int i = 0; i < leafs.size(); i++) {
                int leaf = leafs.get(i);
                isVisited.add(leaf);
                HashSet<Integer> set = neighbors[leaf];
                for (int j : set) {
                    if (!isVisited.contains(j)) {
                        degrees[j]--;
                        if (degrees[j] == 1) {
                            nextLevel.add(j);
                        }
                    }
                }
            }
            leafs = nextLevel;
        }
        return leafs;
    }
}