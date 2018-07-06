class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        boolean similar = true;
        
        if(words1.length != words2.length) {
            return false;
        }
        
        HashSet<String> similaritySet = new HashSet<>();
        
        for(String[] pair : pairs) {
            similaritySet.add(pair[0] + pair[1]);
            similaritySet.add(pair[1] + pair[0]);
        }
        
        for(int i = 0; i < words1.length; i++) {
            if(!similaritySet.contains(words1[i] + words2[i]) && !((words1[i].equals(words2[i])))) {
                return false;
            }   
        }
        
        return similar;
    }
}