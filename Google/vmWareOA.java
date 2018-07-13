
1,2,2,3,4 
public class Solution {
    public int getSum(int[] nums) {
        if (nums == 0 || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                int key = entry.getKey();
                int count = entry.getValue();
                while (count != 1) {
                    while (map.containsKey(key)) {
                        key++;
                    }
                    map.put(key, 1);
                    count--;
                }
            }
        }
        int sum = 0;
        for (int i : map.keySet()) {
            sum += i;
        }
        return sum;
    }
}

public List<Integer> get1(int num) {
    for (int i = 31; i >= 0; i--) {
        if ((num >> i) & 1 == 1) {
            System.out.println(31 - i);
        }
    }
}


class Solution {
    private boolean isIPv4(String IP) {
        int cnt = 0;
        for (char ch : IP.toCharArray()) {
            if (ch == '.') {
                cnt++;
            }
        }

        if (cnt != 3) {
            return false;
        }

        String[] fields = IP.split("\\.");
        if (fields.length != 4) {
            return false;
        }

        for (String field : fields) {
            if (field.isEmpty() || field.length() > 3) {
                return false;
            }

            int sz = field.length();
            for (int i = 0; i < sz; ++i) {
                if (!Character.isDigit(field.charAt(i))) {
                    return false;
                }
            }

            int num = Integer.valueOf(field);
            if (!String.valueOf(num).equals(field) || num < 0 || num > 255) {
                return false;
            }
        }

        return true;
    }

    private boolean isIPv6(String IP) {
        int cnt = 0;
        for (char ch : IP.toCharArray()) {
            if (ch == ':') {
                cnt++;
            }
        }

        if (cnt != 7) {
            return false;
        }

        String[] fields = IP.split(":");
        if (fields.length != 8) {
            return false;
        }

        for (String field : fields) {
            if (field.isEmpty() || field.length() > 4) {
                return false;
            }

            int sz = field.length();
            for (int i = 0; i < sz; ++i) {
                if (!Character.isDigit(field.charAt(i)) && (field.charAt(i) < 'A' || field.charAt(i) > 'F')) {
                    return false;
                }
            }
        }

        return true;
    }

    public String validIPAddress(String IP) {
        if (isIPv4(IP)) {
            return "IPv4";
        }

        if (isIPv6(IP.toUpperCase())) {
            return "IPv6";
        }

        return "Neither";
    }
}




public class CreateBinarySearchTree {

    private TreeNode root;

    public CreateBinarySearchTree() {
    }

    //create a BST on order of elements in the array
    public CreateBinarySearchTree(int[] a) {
        this();
        for (int i : a) {
            add(i);
        }
    }

    private static class TreeNode {
        TreeNode left;
        int item;
        TreeNode right;

        TreeNode(TreeNode left, int item, TreeNode right) {
            this.left = left;
            this.right = right;
            this.item = item; 
        }
    }

    public void add(int item) {
        if (root == null) {
            root = new TreeNode(null, item, null);
            return;
        }

        TreeNode node = root;
        while (true) {
            if (item < node.item) {
                if (node.left == null) {
                    node.left = new TreeNode(null, item, null);
                    break;
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    node.right = new TreeNode(null, item, null);
                    break;
                }
                node = node.right;
            }
        }
    }

    public String toString() {
            return toString(root);
    }

    private String toString(TreeNode node) {
            if (node == null) {
                return null;
            }
        return "[" + toString(node.left) + "," + node.item + "," + toString(node.right) + "]";
    }
}