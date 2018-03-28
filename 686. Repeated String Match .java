class Solution {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder as = new StringBuilder(A);
        for (int rep = 1; rep <= B.length() / A.length() + 2; rep++) {
            if (as.toString().contains(B)) {
                return rep;
            }
            as.append(new StringBuilder(A));
        }
        return -1;
    }
}