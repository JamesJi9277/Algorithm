class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for (int i = s.length() / 2; i > 0; i--) {
            if (s.length() % i == 0) {
                String temp = s.substring(0, i);
                int count = s.length() / i;
                StringBuffer sb = new StringBuffer();
                while (count-- > 0) {
                    sb.append(temp);
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}