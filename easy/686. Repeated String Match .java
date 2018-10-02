class Solution {
    public int repeatedStringMatch(String A, String B) {
        StringBuffer sb = new StringBuffer(A);
        for (int i = 1; i <= B.length() / A.length() + 2; i++) {
            if (sb.toString().contains(B)) {
                return i;
            } else {
                sb.append(A);
            }
        }
        return -1;
    }
}