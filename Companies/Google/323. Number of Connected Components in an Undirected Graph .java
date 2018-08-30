class Solution {
    public int countComponents(int n, int[][] edges) {
        
        int[] roots = new int[n];
        for (int i = 0; i < roots.length; i++) {
            roots[i] = i;
        }
        for (int[] edge : edges) {
            int root1 = findRoot(roots, edge[0]);
            int root2 = findRoot(roots, edge[1]);
            if (root1 != root2) {
                roots[root1] = root2;
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
        	if(roots[i] == i) {
        		count++;
        	}
        }
        return count;
    }
    private int findRoot(int[] roots, int index) {
        while (index != roots[index]) {
            index = roots[index];
        }
        return index;
    }
}