class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character,Integer> lf = new HashMap<>();
        for(char t: T.toCharArray()){
            lf.put(t,lf.getOrDefault(t,0)+1);
        }
        
        StringBuilder sb = new StringBuilder();
        for(char s: S.toCharArray()){
            int freq = lf.getOrDefault(s,0);
            for(int i=0; i<freq; i++){
                sb.append(s);
            }
            lf.remove(s);
        }
        
        for(char t: lf.keySet()){
            int freq = lf.getOrDefault(t,0);
            for(int i=0; i<freq; i++){
                sb.append(t);
            }
        }
        return sb.toString();
    }
}