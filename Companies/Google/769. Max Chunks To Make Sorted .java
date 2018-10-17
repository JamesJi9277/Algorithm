class Solution {
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int count = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                count++;
            }
        }
        return count;
    }
}

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] num = arr.clone();
        Arrays.sort(num);
        int count = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == num[i]) {
                count++;
            }
        }
        return count;
    }
}