class Solution {
    public boolean canTransform(String start, String end) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < start.length(); i++) {
            char c1 = start.charAt(i);
            char c2 = end.charAt(i);
            if (c1 == 'L') {
                left++;
            } else if (c1 == 'R') {
                right++;
            }
            if (c2 == 'L') {
                left--;
            } else if (c2 == 'R') {
                right--;
            }
            if (left > 0 || right < 0 || (left < 0 && right > 0)) {
                return false;
            }
        }
        return left == 0 && right == 0;
    }
}