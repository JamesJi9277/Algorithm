class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                for (int m = 0; m < C.length; m++) {
                    for (int n = 0; n < D.length; n++) {
                        if (A[i] + B[j] + C[m] + D[n] == 0) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}

// 利用空间换时间
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int temp = A[i] + B[j];
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int temp = (C[i] + D[j]) * (-1);
                count += map.getOrDefault(temp, 0);
            }
        }
        return count;
    }
}