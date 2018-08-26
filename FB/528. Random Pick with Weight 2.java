class Solution {

    int[] array;
    Random random;
    public Solution(int[] w) {
        array = new int[w.length];
        random = new Random();
        for (int i = 0; i < w.length; i++) {
            if (i == 0) {
                array[0] = w[0];
            } else {
                array[i] = array[i - 1] + w[i];
            }
        }
    }
    
    public int pickIndex() {
        int target = random.nextInt(array[array.length - 1]) + 1;
        int start = 0;
        int end = array.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (array[start] < target) {
            return end;
        } else {
            return start;
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */