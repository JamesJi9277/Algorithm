class Solution {
    public boolean judgeCircle(String moves) {
        int left = 0;
        int down = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'U') {
                down--;
            } else if (c == 'D') {
                down++;
            } else if (c == 'L') {
                left++;
            } else {
                left--;
            }
        }
        return left == 0 && down == 0;
    }
}