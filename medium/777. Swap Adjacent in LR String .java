// stack overflow
class Solution {
    public boolean canTransform(String start, String end) {
        if (start == null || start.length() == 0 || end == null || end.length() == 0) {
            return false;
        }
        return helper(start, end);
    }
    private boolean helper(String start, String end) {
        if (start.equals(end)) {
            return true;
        }
        for (int i = 0; i < start.length() - 1; i++) {
            if (start.substring(i, i + 2).equals("XL") || start.substring(i, i + 2).equals("RX")) {
                String s = start.substring(i, i + 2).equals("XL") ? 
                    start.substring(0, i) + "LX" + start.substring(i + 2) : 
                start.substring(0, i) + "RX" + start.substring(i + 2);
                return helper(s, end);
            }
        }
        return false;
    }
}

class Solution {
    public boolean canTransform(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", "")))
            return false;
        
        int p1 = 0;
        int p2 = 0;
        
        while(p1 < start.length() && p2 < end.length()){
            
            // get the non-X positions of 2 strings
            while(p1 < start.length() && start.charAt(p1) == 'X'){
                p1++;
            }
            while(p2 < end.length() && end.charAt(p2) == 'X'){
                p2++;
            }
            
            //if both of the pointers reach the end the strings are transformable
            if(p1 == start.length() && p2 == end.length()){
                return true;
            }
            // if only one of the pointer reach the end they are not transformable
            if(p1 == start.length() || p2 == end.length()){
                return false;
            }
            
            if(start.charAt(p1) != end.charAt(p2)){
                return false;
            }
            // if the character is 'L', it can only be moved to the left. p1 should be greater or equal to p2.
            if(start.charAt(p1) == 'L' && p2 > p1){
                return false;
            }
            // if the character is 'R', it can only be moved to the right. p2 should be greater or equal to p1.
            if(start.charAt(p1) == 'R' && p1 > p2){
                return false;
            }
            p1++;
            p2++;
        }
        return true;
    }
}


class Solution {
    public boolean canTransform(String start, String end) {
        if (start == null || start.length() == 0 || end == null || end.length() == 0) {
            return false;
        }
        int p = 0;
        int q= 0;
        while (p < start.length() && q < end.length()) {
            while (p < start.length() && start.charAt(p) == 'X') {
                p++;
            }
            while (q < end.length() && end.charAt(q) == 'X') {
                q++;
            }
            if (p == start.length() && q == end.length()) {
                return true;
            }
            if (p == start.length() || q == end.length()) {
                return false;
            }
            if (start.charAt(p) != end.charAt(q)) {
                return false;
            }
            if (start.charAt(p) == 'L' && q > p) {
                return false;
            }
            if (start.charAt(p) == 'R' && p > q) {
                return false;
            }
            p++;
            q++;
        }
        return true;
    }
}