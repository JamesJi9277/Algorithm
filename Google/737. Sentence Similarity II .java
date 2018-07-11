class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        HashMap<String, String> roots = new HashMap<>();
        for (String[] p : pairs) {
            //因为是可以相通的，所以这里跟找环一样，先找root再连接
            String s1 = findRoot(roots, p[0]);
            String s2 = findRoot(roots, p[1]);
            if (!s1.equals(s2)) {
                roots.put(s1, s2);
            }
        }
        for (int i = 0; i < words1.length; i++) {
            String root1 = findRoot(roots, words1[i]);
            String root2 = findRoot(roots, words2[i]);
            if (!root1.equals(root2)) {
                return false;
            }
        }
        return true;
    }
    private String findRoot(HashMap<String, String> map, String s) {
        if (!map.containsKey(s)) {
            map.put(s, s);
        }
        while (!s.equals(map.get(s))) {
            s = map.get(s);
        }
        return s;
    }
}