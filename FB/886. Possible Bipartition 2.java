class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        if (dislikes == null || dislikes.length == 0) {
            return true;
        }
        Set<Integer> g1 = new HashSet<>();
        Set<Integer> g2 = new HashSet<>();
        g1.add(dislikes[0][0]);
        g2.add(dislikes[0][1]);
        for (int i = 1; i < dislikes.length; i++) {
            if ((g1.contains(dislikes[i][0]) && g1.contains(dislikes[i][1])) 
                || (g2.contains(dislikes[i][0]) && g2.contains(dislikes[i][1]))) {
                return false;
            }
            if (g1.contains(dislikes[i][0])) {
                g2.add(dislikes[i][1]);
            } else if (g2.contains(dislikes[i][0])) {
                g1.add(dislikes[i][1]);
            }

            if (g1.contains(dislikes[i][1])) {
                g2.add(dislikes[i][0]);
            } else if (g2.contains(dislikes[i][1])) {
                g1.add(dislikes[i][0]);
            }
        }
        return true;
    }
}