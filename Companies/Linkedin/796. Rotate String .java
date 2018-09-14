class Solution {
    public boolean rotateString(String A, String B) {
        String s = A + A;
        return A.length() == B.length() && s.contains(B);
    }
}