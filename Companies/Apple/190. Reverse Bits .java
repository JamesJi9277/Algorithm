//是将bit去reverse
//而不是将0变成1，1变成0

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            // first solution
            if (((n >> i) & 1) == 1) {
                res = (res << 1) + 1;
            } else {
                res <<= 1;
            }
            // second solution
            res = (res << 1) | ((n >> i) & 1);
        }
        return res;
    }
}


public class Solution {
    // you need treat n as an unsigned value
    Map<Byte, Integer> map = new HashMap<>();
    public int reverseBits(int n) {
        byte[] bytes = new byte[4];
        for (int i = 0; i < 4; i++) {
            bytes[i] = (byte)((n >> 8 * i) & 255);
        }
        int res = 0;
        for (int i = 0; i < 4; i++) {
            res += reverse(bytes[i]);
            if (i < 3) {
                res <<= 8;
            }
        }
        return res;
    }
    private int reverse(byte b) {
        if (map.containsKey(b)) {
            return map.get(b);
        }
        int value = 0;
        for (int i = 0; i < 8; i++) {
            value = (value << 1) | ((b >> i) & 1);
        }
        map.put(b, value);
        return value;
    }
}