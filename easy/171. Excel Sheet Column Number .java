class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result = result * 26 + (s.charAt(i) - 'A' + 1);
        }
        return result;
    }
}

class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        int weight = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            res = res + (s.charAt(i) - 'A' + 1) * weight;
            weight *= 26;
        }
        return res;
    }
}