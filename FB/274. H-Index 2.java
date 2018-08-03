//直接从题意开始理解，作为一种naive的做法
class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        int max = 0;
        for (int i = citations.length - 1; i >= 0; i--) {
            int paper = citations.length - i;
            int citation = citations[i];
            if (citation >= paper) {
                max = Math.max(max, paper);
            }
        }
        return max;
    }
}

class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int length = citations.length;
        int[] suffix = new int[length + 1];
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= length) {
                suffix[length]++;
            } else {
                suffix[citations[i]]++;
            }
        }
        for (int i = length - 1; i >= 0; i--) {
            suffix[i] += suffix[i + 1];
        }
        for (int i = length; i >= 0; i--) {
            if (suffix[i] >= i) {
                return i;
            }
        }
        return 0;
    }
}