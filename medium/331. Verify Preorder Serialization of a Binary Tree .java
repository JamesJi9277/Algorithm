class Solution {
    public boolean isValidSerialization(String preorder) {
        // diff = outdegree - indegree
        // all non-null node provides 2 outdegree and 1 indegree (2 children and 1 parent), except root
        // all null node provides 0 outdegree and 1 indegree (0 child and 1 parent).
        if (preorder == null || preorder.length() == 0) {
            return false;
        }
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node : nodes) {
            if (--diff < 0) {
                return false;
            }
            if (!node.equals("#")) {
                diff += 2;
            }
        }
        return diff == 0;
    }
}

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