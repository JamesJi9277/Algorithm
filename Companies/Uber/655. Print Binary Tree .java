class Solution {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        int row = getHeight(root);
        int col = (int)Math.pow(2, row) - 1;
        for (int i = 0; i < row; i++) {
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                temp.add("");
            }
            res.add(temp);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<int[]> indexes = new LinkedList<>();
        queue.offer(root);
        indexes.offer(new int[]{0, col - 1});
        int index = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            index++;
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                int[] range = indexes.poll();
                int mid = range[0] + (range[1] - range[0]) / 2;
                res.get(index).set(mid, "" + temp.val);
                
                if (temp.left != null) {
                    queue.offer(temp.left);
                    indexes.offer(new int[]{range[0], mid - 1});
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                    indexes.offer(new int[]{mid + 1, range[1]});
                }
            }
        }
        return res;
    }
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }
}

class Solution {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        int row = getHeight(root);
        int col = (int)Math.pow(2, row) - 1;
        for (int i = 0; i < row; i++) {
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                temp.add("");
            }
            res.add(temp);
        }
        helper(root, res, 0, 0, col - 1);
        return res;
    }
    private void helper(TreeNode root, List<List<String>> res, int row, int start, int end) {
        if (root == null || start > end) {
            return;
        }
        int mid = start + (end - start) / 2;
        res.get(row).set(mid, "" + root.val);
        helper(root.left, res, row + 1, start, mid - 1);
        helper(root.right, res, row + 1, mid + 1, end);
    }
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }
}