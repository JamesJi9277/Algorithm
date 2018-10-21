class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        for (char c : letters) {
            if (c > target) {
                return c;
            }
        }
        return letters[0];
    }
}

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if (letters == null || letters.length == 0) {
            return 'z';
        }
        if (letters[letters.length - 1] <= target) {
            return letters[0];
        }
        if (letters[0] > target) {
            return letters[0];
        }
        int start = 0;
        int end = letters.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (letters[start] > target) {
            return letters[start];
        } else {
            return letters[end];
        }
    }
}