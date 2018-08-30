public class Solution{
    public boolean isNumber(String s){
        s = s.trim();
        if(s.length() > 0 && s.charAt(s.length() - 1 ) == 'e')
            return false;
        String[] t = s.split("e");
        if(t.length == 0 || t.length > 2)
            return false;
        boolean res = valid(t[0], false);
        if(t.length > 1)
            res = res && valid(t[1], true);
        return res;
    }
    private boolean valid(String s , boolean hasDot){
        if (s.length() > 0 && (s.charAt(0) == '+' || s.charAt(0) == '-'))
            s = s.substring(1);
        char[] arr = s.toCharArray();
        if(arr.length == 0|| s.equals("."))
            return false;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '.')
            {
                if(hasDot)
                    return false;
                hasDot = true;
            }
            else if(!(arr[i] >= '0' && arr[i] <= '9'))
                return false;
        }
        return true;
    }
}