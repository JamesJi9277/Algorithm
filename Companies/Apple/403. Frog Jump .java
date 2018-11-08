class Solution {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < stones.length; i++) {
            if (i > 2 && stones[i] > 2 * stones[i - 1]) {
                return false;
            }
            set.add(stones[i]);
        }
        return helper(stones[0], stones[stones.length - 1], set, 0);
    }
    private boolean helper(int start, int end, Set<Integer> set, int step) {
        if (start > end) {
            return false;
        }
        if (start == end) {
            return true;
        }
        for (int i = step + 1; i > 0 && i >= step - 1; i--) {
            if (set.contains(start + i) && helper(start + i, end, set, i)) {
                return true;
            }
        }
        return false;
    }
}