// 思想其实并不复杂，慢慢找substring然后复制后跟原string比较
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        // 可以从中间开始，因为考虑到index是从0开始的，
        // 所以正好抵消了substring的index要减一位的问题
        for (int i = s.length() / 2; i > 0; i--) {
            if (s.length() % i == 0) {
                int count = s.length() / i;
                String ss = s.substring(0, i);
                StringBuffer sb = new StringBuffer();
                while (count-- > 0) {
                    sb.append(ss);
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}