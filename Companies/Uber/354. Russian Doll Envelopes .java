// sort on ascend in width and decend in height
// then find longest increasing subsequence based on height
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < envelopes.length; i++) {
            if (res.isEmpty() || res.get(res.size() - 1)[1] < envelopes[i][1]) {
                res.add(envelopes[i]);
            } else if (res.get(0)[1] > envelopes[i][1]) {
                res.set(0, envelopes[i]);
            } else {
                int index = binarySearch(res, envelopes[i][1]);
                res.set(index, envelopes[i]);
            }
        }
        return res.size();
    }
    private int binarySearch(List<int[]> res, int target) {
        int start = 0;
        int end = res.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (res.get(mid)[1] == target) {
                return mid;
            } else if (res.get(mid)[1] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (res.get(start)[1] == target) {
            return start;
        } else {
            return end;
        }
    }
}