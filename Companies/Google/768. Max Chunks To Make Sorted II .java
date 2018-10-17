class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] minRight = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (i == arr.length - 1) {
                minRight[i] = arr[i];
            } else {
                minRight[i] = Math.min(minRight[i + 1], arr[i]);
            }
        }
        int max = 0;
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            max = Math.max(max, arr[i]);
            if (max <= minRight[i + 1]) {
                count++;
            }
        }
        return count + 1;
    }
}