//https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/discuss/78551/7-lines-Easy-Java-Solution
class Solution {
    public boolean isValidSerialization(String preorder) {
        // diff represent out - in
        // non null: 2 out and 1 in
        // null : 0 out and 1 in
        if (preorder == null || preorder.length() == 0) {
            return false;
        }
        int diff = 1;
        String[] strs = preorder.split(",");
        for (int i = 0; i < strs.length; i++) {
            if (--diff < 0) {
                return false;
            }
            if (!strs[i].equals("#")) {
                diff += 2;
            }
        }
        return diff == 0;
    }
}