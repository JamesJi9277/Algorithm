class Solution {
    public int findMaximumXOR(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                res = Math.max(res, nums[i] ^ nums[j]);
            }
        }
        return res;
    }
}

class Solution {
    class TrieNode {
        TrieNode zero;
        TrieNode one;
    }
    public int findMaximumXOR(int[] nums) {
        //相当于是找最长不同的prefix
        if (nums == null || nums.length == 0) {
            return 0;
        }
        TrieNode root = new TrieNode();
        for (int i : nums) {
            TrieNode node = root;
            for (int j = 31; j >= 0; j--) {
                int bit = (i >> j) & 1;
                if (bit == 1) {
                    if (node.one == null) {
                        node.one = new TrieNode();
                    }
                    node = node.one;
                } else if (bit == 0) {
                    if (node.zero == null) {
                        node.zero = new TrieNode();
                    }
                    node = node.zero;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            TrieNode node = root;
            int xor = 0;
            for (int j = 31; j >= 0; j--) {
                int bit = (i >> j) & 1;
                if (bit == 1) {
                    if (node.zero != null) {
                        node = node.zero;
                        xor += 1 << j;
                    } else {
                        node = node.one;
                        xor += 0 << j;
                    }
                } else {
                    if (node.one != null) {
                        node = node.one;
                        xor += 1 << j;
                    } else {
                        node = node.zero;
                        xor += 0 << j;
                    }
                }
            }
            max = Math.max(max, xor);
        }
        return max;
    }
}