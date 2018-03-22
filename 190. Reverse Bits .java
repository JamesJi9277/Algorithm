public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;   // CATCH: must do unsigned shifts，不断地把位来往后推，再用与1来直接get bit，
            if (i < 31) // CATCH: for last digit, don't shift! 然后result在不断地往左移动来达到shift的目的，精妙绝伦！
                result <<= 1;
        }
        return result;
    }
}
// The signed left shift operator "<<" shifts a bit pattern to the left

// The signed right shift operator ">>" shifts a bit pattern to the right.

// The unsigned right shift operator ">>>" shifts a zero into the leftmost position


public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += n & 1;
            n >>>= 1;
            if (i < 31) {
                res <<= 1;
            }
        }
        return res;
    }
}