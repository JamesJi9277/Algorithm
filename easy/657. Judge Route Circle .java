class Solution {
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) {
            return true;
        }
        int[] count = helper(moves);
        if (count[0] == count[1] && count[2] == count[3]) {
            return true;
        }
        return false;
    }
    private int[] helper(String s) {
        char[] array = s.toCharArray();
        int[] result = new int[4];
        for (char c : array) {
            if (c == 'R') {
                result[0]++;
            } else if (c == 'L') {
                result[1]++;
            } else if (c == 'U') {
                result[2]++;
            } else {
                result[3]++;
            }
        }
        return result;
    }
}