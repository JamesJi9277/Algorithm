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
        if (letters[letters.length - 1] <= target) {
            return letters[0];
        }
        int start = 0;
        int end = letters.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // 因为是要找第一个比他大的，所以只要是小于等于全部都要往左边找
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