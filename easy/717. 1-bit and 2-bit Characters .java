class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i] == 0) {
                i++;
            } else {
                i += 2;
            }
        }
        return i == bits.length - 1;
    }
}

// 因为这个题问的是must be one bit
// 所以在写法上就自由了好多，可以直接定义成当出现1的时候我就直接+2
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int index = 0;
        while (index < bits.length - 1) {
            if (bits[index] == 0) {
                index++;
            } else {
                index += 2;
            }
        }
        return index == bits.length - 1;
    }
}