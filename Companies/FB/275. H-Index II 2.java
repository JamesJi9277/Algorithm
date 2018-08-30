public class Solution {
    public int hIndex(int[] citations) {
        // if(citations == null || citations.length == 0) {
        //     return 0;
        // }
        // int start = 0;
        // int end = citations.length - 1;
        // while(start + 1 < end) {
        //     int mid = start + (end - start) / 2;
        //     if(citations[mid] >= citations.length - mid) {
        //         end = mid;
        //     }
        //     else {
        //         start = mid;
        //     }
        // }
        // if(citations[start] >= citations.length - start) {
        //     return citations.length - start;
        // }
        // else if(citations[end] >= citations.length - end) {
        //     return citations.length - end;
        // }
        // else {
        //     return 0;
        // }
        if (citations == null || citations.length == 0) {
            return 0;
        }
        // Arrays.sort(citations);
        // int max = 0;
        // for (int i = citations.length - 1; i >= 0; i--) {
        //     int numPaper = citations.length - i;
        //     int numCitation = citations[i];
        //     if (numCitation >= numPaper) {
        //         max = Math.max(max, numPaper);
        //     }
        // }
        // return max;
        // int length = citations.length;
        // int[] suffix = new int[length + 1];
        // for (int i = 0; i < citations.length; i++) {
        //     if (citations[i] > length) {
        //         suffix[length]++;
        //     } else {
        //         suffix[citations[i]]++;
        //     }
        // }
        // for (int i = length - 1; i >= 0; i--) {
        //     suffix[i] += suffix[i + 1];
        // }
        // for (int i = length; i >= 0; i--) {
        //     if (suffix[i] >= i) {
        //         return i;
        //     }
        // }
        // return 0;
        
        int start = 0;
        int end = citations.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (citations[mid] >= citations.length - mid) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (citations[start] >= citations.length - start) {
            return citations.length - start;
        } else if (citations[end] >= citations.length - end) {
            return citations.length - end;
        } else {
            return 0;
        }
    }
}
