class Solution {
    public int findMinDifference(List<String> list) {
        if (list == null || list.size() == 0) {
            return 0;
        }
        boolean[] marked = new boolean[24 * 60];
        for (String s : list) {
            String[] s1 = s.split(":");
            int index = Integer.parseInt(s1[0]) * 60 + Integer.parseInt(s1[1]);
            if (marked[index]) {
                return 0;
            }
            marked[index] = true;
        }
        int prev = 0;
        int min = Integer.MAX_VALUE;
        int first = Integer.MAX_VALUE;
        int last = Integer.MIN_VALUE;
        for (int i = 0; i < marked.length; i++) {
            if (marked[i]) {
                if (first != Integer.MAX_VALUE) {
                    min = Math.min(min, i - prev);
                }
                first = Math.min(first, i);
                last = Math.max(last, i);
                prev = i;
            }
        }
        min = Math.min(min, 24 * 60 - last + first);
        return min;
    }
}