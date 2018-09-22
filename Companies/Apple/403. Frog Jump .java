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
        return helper(stones, 0, 0, stones[stones.length - 1], set);
    }
    private boolean helper(int[] stones, int start, int step, int end, Set<Integer> set) {
        if (start == end) {
            return true;
        }
        for (int i = step + 1; i >= step - 1 && i > 0; i--) {
            if (set.contains(start + i)) {
                if (helper(stones, start + i, i, end, set)) {
                    return true;
                }
            }
        }
        return false;
    }
}