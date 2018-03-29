class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || pattern.length() == 0 || str == null || str.length() == 0) {
            return false;
        }
        String[] arr = str.split(" ");
        int len = pattern.length();
        if(arr.length != len){
            return false;
        }
        Map<Character, String> table = new HashMap<Character, String>();
        for( int i = 0; i < len; i++){
            char c = pattern.charAt(i);
            if( table.containsKey(c) && !table.get(c).equals(arr[i])){
                return false;
            }
            else if( !table.containsKey(c) && table.contains(arr[i])){
                return false;
            }
            else{
                table.put(c, arr[i]);
            }
        }
        return true;
    }
}


class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }
}