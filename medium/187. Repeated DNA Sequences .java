class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() < 10) {
            return res;
        }
        int left = 0;
        int right = 9;
        Set<String> set = new HashSet<String>();
        while (right < s.length()) {
            String temp = s.substring(left, right + 1);
            if (set.contains(temp) && !res.contains(temp)) {
                res.add(temp);
            } else {
                set.add(temp);
            }
            right++;
            left++;
        }
        return res;
    }
}