class Solution {
    int[] prefix;
    Random random;
    public Solution(int[] w) {
        random = new Random();
        prefix = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            if (i == 0) {
                prefix[i] = w[i];
            } else {
                prefix[i] = prefix[i - 1] + w[i];
            }
        }
    }
    
    public int pickIndex() {
        int target = random.nextInt(prefix[prefix.length - 1]) + 1;
        int start = 0;
        int end = prefix.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (prefix[mid] == target) {
                return mid;
            } else if (prefix[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (prefix[start] >= target) {
            return start;
        } else {
            return end;
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */