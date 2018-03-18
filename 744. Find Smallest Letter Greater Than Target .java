class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        // 全扫一遍，如果target到了末尾，那就返回letters第一个
        for (char c : letters) {
            int diff = (int) (c - target);
            if (diff > 0) {
                return c;
            }
        }
        return letters[0];
    }
}