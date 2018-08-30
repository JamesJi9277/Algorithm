// Given a non-negative integer, 
// you could swap two digits at most once to get the maximum valued number. 
// Return the maximum valued number you could get.
// Input: 2736
// Output: 7236
// Explanation: Swap the number 2 and the number 7.
class Solution {
    public int maximumSwap(int num) {
        // find max number behind
        // how to find behind? -> index!
        if (num == 0) {
            return 0;
        }
        int[] bucket = new int[10];
        char[] array = Integer.toString(num).toCharArray();
        for (int i = 0; i < array.length; i++) {
            bucket[array[i] - '0'] = i;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 9; j > array[i] - '0'; j--) {
                if (bucket[j] > i) 
                    char temp = array[i];
                    array[i] = array[bucket[j]];
                    array[bucket[j]] = temp;
                    return Integer.valueOf(new String(array));
                }
            }
        }
        return num;
    }
}
