/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
  public int closestValue(TreeNode root, double target) {
    ArrayList<Double> res = new ArrayList<Double>();
    doTraverse(root, res);
    double minDiff = Double.POSITIVE_INFINITY;
    double result = 0;
    for(int i = 0; i < res.size(); i++) {
        if(minDiff > Math.abs(target - res.get(i))) {
            minDiff = Math.abs(target - res.get(i));
            result = res.get(i);
        }
    }
    return (int)result;
  }
  private void doTraverse(TreeNode root, ArrayList<Double> res) {
    if(root == null) {
      return ;
    }
    doTraverse(root.left, res);
    res.add((double)root.val);
    doTraverse(root.right, res);
  }
}


public class Solution {
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        double min = Double.POSITIVE_INFINITY;
        int res = 0;
        while (root != null) {
            if (min > Math.abs(root.val - target)) {
                min = Math.abs(root.val - target);
                res = root.val;
            }
            if ((double)root.val == target) {
                return root.val;
            } else if ((double)root.val > target) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
    }
}

class Solution {
    public int closestValue(TreeNode root, double target) {
        int res = 0;
        double min = Double.POSITIVE_INFINITY;
        while (root != null) {
            if (Math.abs((double)root.val - target) < min) {
                min = Math.abs((double)root.val - target);
                res = root.val;
            }
            if ((double)root.val > target) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
    }
}