// TLE
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (words == null || words.length < 2) {
            return res;
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    continue;
                }
                List<Integer> temp = new ArrayList<Integer>();
                String s = words[j] + words[i];
                if (isPalindrome(s)) {
                    temp.add(j);
                    temp.add(i);
                    res.add(temp);
                }
            }
        }
        return res;
    }
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}