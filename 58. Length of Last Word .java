//需要考虑到" "的情况，这样split了也没用，需要用到trim
class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if(s == null || s.length() == 0) {
            return 0;
        }
        String[] splited = s.split(" ");
        return splited[splited.length - 1].length();
    }
}