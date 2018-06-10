class Solution {
    public int maximumSwap(int num) {
        if (num == 0) {
            return 0;
        }
        char[] array = Integer.toString(num).toCharArray();
        int[] buckets = new int[10];
        for (int i = 0; i < array.length; i++) {
            buckets[array[i] - '0'] = i;
        }
        for (int i = 0; i < array.length; i++) {
            for (int k = 9; k > (array[i] - '0'); k--) {
                if (buckets[k] > i) {
                    char temp = array[i];
                    array[i] = array[buckets[k]];
                    array[buckets[k]] = temp;
                    return Integer.valueOf(new String(array));
                }
            }
        }
        return num;
    }
}

https://leetcode.com/problems/maximum-swap/discuss/107068/Java-simple-solution-O(n)-time