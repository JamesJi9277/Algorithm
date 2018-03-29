class Solution {
    public int countPrimeSetBits(int L, int R) {
        if (R < L) {
            return 0;
        }
        int count = 0;
        for (int i = L; i <= R; i++) {
            if (valid(i)) {
                count++;
            }
        }
        return count;
    }
    private boolean valid(int num) {
        int setBit = 0;
        for (int i = 0; i < 32; i++) {
            int bit = (num >> i) & 1;
            if (bit == 1) {
                setBit++;
            }
        }
        return isPrime(setBit);
    }
    private boolean isPrime(int num) {
        Set<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19 /*, 23, 29 */ ));
        return primes.contains(num);
    }
}