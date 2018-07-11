class Solution {
    // relation is not transitive
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        Set<String> set = new HashSet<>();
        for (String[] p : pairs) {
            set.add(p[0] + p[1]);
            set.add(p[1] + p[0]);
        }
        for (int i = 0; i < words1.length; i++) {
            //如果不相等就应该是会出现对应的关系
            if (!(words1[i].equals(words2[i]) || !set.contains(words1[i] + words2[i]))) {
                return false;
            }
        }
        return true;
    }
}