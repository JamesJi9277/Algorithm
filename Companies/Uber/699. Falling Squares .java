class Solution {
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (positions == null) {
            return res;
        }
        TreeSet<int[]> set = new TreeSet<>((a, b) -> (b[2] - a[2]));
        int maxHeight = 0;
        for (int[] pos : positions) {
            int start = pos[0];
            int end = pos[0] + pos[1] - 1;
            int height = 0;
            for (int[] s : set) {
                if (Math.max(start, s[0]) <= Math.min(end, s[1]) && height < s[2]) {
                    height = s[2];
                }
            }
            height += pos[1];
            set.add(new int[]{start, end, height});
            maxHeight = Math.max(maxHeight, height);
            res.add(maxHeight);
        }
        return res;
    }
}