class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            int res = (((x >> i) & 1) ^ ((y >> i)& 1));
            if (res == 1) {
                count++;
            }
        }
        return count;
    }
}