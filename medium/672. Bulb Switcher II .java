/** 1 + 2 -> 3;
 *  1 + 3 -> 2;
 *  2 + 3 -> 1;
 *  so all cases are: all_on, 1, 2, 3, 4, 1+4, 2+4, 3+4;
 *  when m == 1, can only have 4 states ( 1, 2, 3, 4)
 *  when m == 2, can only have 7states (all_on, 1, 2, 3, 1+4, 2+4, 3+4)
 *  when m == 3, can get all 8 states
 *  special case analysis required when n < 3;
 */
class Solution {
    public int flipLights(int n, int m) {
        if (m == 0 || n == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        } else if (n == 2) {
            return (m == 1) ? 3 : 4;
        } else {
            return (m == 1) ? 4 : (m == 2) ? 7 : 8;
        }
    }
}