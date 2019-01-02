/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(list, root);
        return findKth(list, k);
    }
    private void inorder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }
    private int findKth(List<Integer> list, int k) {
        return helper1(list, 0, list.size() - 1, k);
    }
    private int helper1(List<Integer> list, int start, int end, int k) {
        int left = start;
        int right = end;
        int pivot = list.get(left);
        while (left < right) {
            while (left < right && list.get(right) >= pivot) {
                right--;
            }
            if (left < right) {
                list.set(left++, list.get(right));
            }
            while (left < right && list.get(left) < pivot) {
                left++;
            }
            if (left < right) {
                list.set(right--, list.get(left));
            }
        }
        list.set(left, pivot);
        if (left + 1 == k) {
            return list.get(left);
        } else if (left + 1 < k) {
            return helper1(list, left + 1, end, k);
        } else {
            return helper1(list, start, left - 1, k);
        }
    }
}


class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        TreeNode temp = null;
        while (root != null && res.size() < k) {
            if (root.left != null) {
                temp = root.left;
                while (temp.right != null && temp.right != root) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = root;
                    root = root.left;
                } else {
                    res.add(root.val);
                    temp.right = null;
                    root = root.right;
                }
            } else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res.get(k - 1);
    }
}


class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        inorder(res, root, k);
        return res.get(k - 1);
    }
    private void inorder(List<Integer> res, TreeNode root, int k) {
        if (root == null || res.size() == k) {
            return;
        }
        inorder(res, root.left, k);
        res.add(root.val);
        inorder(res, root.right, k);
    }
}