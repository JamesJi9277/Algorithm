class Solution {
    public int expressiveWords(String s, String[] words) {
        if(s == null || words == null) return 0;
        
        int stretchCount = 0;
        
        for(String t : words){
            if(canStretch(s, t)) {
                stretchCount ++;    
                // System.out.println(t);
            }
        }
        
        return stretchCount;
    }

    boolean canStretch(String stretchedWord, String target){
        if(stretchedWord.length() < target.length()) return false;
        
        int i = 0, j =0;

        while(i<stretchedWord.length() && j<target.length()){
            if(stretchedWord.charAt(i) != target.charAt(j)) return false;
            
            int endS = i+1;
            while(endS<stretchedWord.length() && stretchedWord.charAt(endS) == stretchedWord.charAt(endS - 1)) endS++;
            
            int endT = j+1;
            while(endT<target.length() && target.charAt(endT) == target.charAt(endT - 1)) endT++;
            
            if(endS - i < endT - j) return false;
            if(endS - i > endT - j && endS - i < 3)  return false;
            
            i = endS;
            j = endT;
        }
        
        return i >= stretchedWord.length();
    }
}