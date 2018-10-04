class Solution {
    public int lenLongestFibSubseq(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : A) {
            set.add(i);
        }
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int a = A[i];
                int b = A[j];
                int count = 2;
                while (set.contains(a + b)) {
                    count++;
                    int temp = a;
                    a = b;
                    b += temp;
                }
                max = Math.max(max, count);
            }
        }
        return max > 2 ? max : 0;
    }
}