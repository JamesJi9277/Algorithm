class Solution {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) {
            return false;
        }
        //dfs进行分段来扫，set来寸石头
        // 记得步数不能够为负，aka不能反方向走
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < stones.length; i++) {
            // 这里一定是i > 2，考虑到0， 1的时候，我怎么样都是可以跳过去的
            if (i > 2 && stones[i] > stones[i - 1] * 2) {
                return false;
            }
            set.add(stones[i]);
        }
        // 记住这个end是stone[stone.length - 1]
        return helper(stones, 0, 0, stones[stones.length - 1], set);
    }
    private boolean helper(int[] stones, int start, int step, int end, Set<Integer> set) {
        if (start == end) {
            return true;
        }
        for (int i = step + 1; i >= step - 1; i--) {
            if (i > 0 && set.contains(start + i) && helper(stones, start + i, i, end, set)) {
                return true;
            }
        }
        return false;
    }
}