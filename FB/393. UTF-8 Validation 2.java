class Solution {
    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) {
            return true;
        }
        int i = 0;
        int numOnes = 0;
        while (i < data.length) {
            numOnes = count(data[i]);
            if (numOnes == 0) {
                i++;
                continue;
            }
            if (numOnes == 1 || numOnes > 4) {
                return false;
            }
            if (i + numOnes - 1 >= data.length) {
                return false;
            }
            int j;
            for (j = i + 1; j < i + numOnes; j++) {
                if (!firstTwoValid(data[j])) {
                    return false;
                }
            }
            i = j;
        }
        return true;
    }
    private int count(int num) {
        int count = 0;
        String s = Integer.toBinaryString(num);
        if (s.length() < 8) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '1') {
                break;
            }
            count++;
        }
        return count;
    }
    private boolean firstTwoValid(int num) {
        String s = Integer.toBinaryString(num);
        if (s.length() < 8) {
            return false;
        }
        return s.startsWith("10");
    }
}