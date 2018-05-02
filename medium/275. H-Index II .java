class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int res = 0;
        int length = citations.length;
        for(int i = length - 1; i >= 0; i--) {
            int numPaper = length - i;
            int numCitation = citations[i];
            if(numCitation >= numPaper) {
                res = Math.max(res, numPaper);
            }
        }
        return res;
    }
}


public class Solution {
    public int hIndex(int[] citations) {
        // 只要是sorted的情况下就可以考虑binary search
        if(citations == null || citations.length == 0) {
            return 0;
        }
        int start = 0;
        int end = citations.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(citations[mid] >= citations.length - mid) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        if(citations[start] >= citations.length - start) {
            return citations.length - start;
        }
        else if(citations[end] >= citations.length - end) {
            return citations.length - end;
        }
        else {
            return 0;
        }
    }
}
