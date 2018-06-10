class Solution {
    public int maximumSwap(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        int[] buckets = new int[10];
        for (int i = 0; i < chars.length; i++) {
            buckets[chars[i] - '0'] = i;
        }
        for (int i = 0; i < chars.length; i++) {
            for (int k = 9; k > chars[i] - '0'; k--) {
                if (buckets[k] > i) {
                    char temp = chars[i];
                    chars[i] = chars[buckets[k]];
                    chars[buckets[k]] = temp;
                    return Integer.valueOf(new String(chars));
                }
            }
        }
        return num;
    }
}

https://leetcode.com/problems/maximum-swap/discuss/107068/Java-simple-solution-O(n)-time