class Solution {
    public boolean canCross(int[] stones) {
        if (stones == null) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < stones.length; i++) {
            if (i > 2 && stones[i] > 2 * stones[i - 1]) {
                return false;
            }
            set.add(stones[i]);
        }
        return helper(stones, set, 0, 0, stones[stones.length - 1]);
    }
    private boolean helper(int[] stones, Set<Integer> set, int start, int step, int end) {
        if (start == end) {
            return true;
        }
        for (int i = step + 1; i >= step - 1 && i > 0; i--) {
            if (set.contains(start + i) && helper(stones, set, start + i, i, end)) {
                return true;
            }
        }
        return false;
    }
}