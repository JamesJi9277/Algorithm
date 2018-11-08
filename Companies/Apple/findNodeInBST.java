// find largest node hwich is less or equal than target
public TreeNode find(TreeNode root, int target) {
	if (root == null || root.val == target) {
		return root;
	}
	if (root.val < target) {
		TreeNode temp = find(root.right, target);
		return temp == null ? root : temp;
	} else {
		return find(root.left, target);
	}
}

// smallest number which is greater or equal than target

public TreeNode find1(TreeNode root, int target) {
	if (root == null || root.val == target) {
		return root;
	}
	if (root.val > target) {
		TreeNode left = find1(root.left, target);
		return left == null ? root : left;
	} else {
		return find1(root.right, target);
	}
}