class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] count = new int[1000];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int odd = 0;
        for (int i : count) {
            if (i % 2 == 1) {
                odd++;
            }
        }
        return odd < 2;
    }
}