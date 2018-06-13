class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<Integer>();
        if (s == null || s.length() == 0) {
            return res;
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > right) {
                res.add(right - left + 1);
                left = i;
            }
            right = Math.max(right, s.lastIndexOf(s.charAt(i)));
        }
        res.add(right - left + 1);
        return res;
    }
}