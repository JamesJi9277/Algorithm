class Solution {
    Map<Integer, List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int N) {
        if (N < 1) {
            return new ArrayList<TreeNode>();
        }
        if (map.containsKey(N)) {
            return map.get(N);
        }
        List<TreeNode> res = new ArrayList<>();
        if (N == 1) {
            res.add(new TreeNode(0));
            map.put(0, res);
            return res;
        }
        for (int left = 1; left < N; left += 2) {
            List<TreeNode> leftPart = allPossibleFBT(left);
            List<TreeNode> rightPart = allPossibleFBT(N - left - 1);
            for (TreeNode left1 : leftPart) {
                for (TreeNode right1 : rightPart) {
                    TreeNode root = new TreeNode(0);
                    root.left = left1;
                    root.right = right1;
                    res.add(root);
                }
            }
        }
        map.put(N, res);
        return res;
    }
}

class Solution {
    public List<TreeNode> allPossibleFBT(int N) {
        if (N < 1) {
            return new ArrayList<TreeNode>();
        }
        List<TreeNode> res = new ArrayList<>();
        if (N == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        for (int left = 1; left < N; left += 2) {
            List<TreeNode> leftPart = allPossibleFBT(left);
            List<TreeNode> rightPart = allPossibleFBT(N - left - 1);
            for (TreeNode left1 : leftPart) {
                for (TreeNode right1 : rightPart) {
                    TreeNode root = new TreeNode(0);
                    root.left = left1;
                    root.right = right1;
                    res.add(root);
                }
            }
        }
        return res;
    }
}