https://leetcode.com/problems/longest-absolute-file-path/discuss/86615/9-lines-4ms-Java-solution

class Solution {
    public int lengthLongestPath(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        Deque<Integer> deque = new ArrayDeque<Integer>();
        deque.push(0);
        int maxLen = 0;
        for (String s : input.split("\n")) {
            int lev = s.lastIndexOf("\t") + 1; // number of \t
            while (lev < deque.size() - 1) {
                deque.pop();
            }
            int len = deque.peek() + s.length() - lev + 1;
            deque.push(len);
            
            if (s.contains(".")) {
                maxLen = Math.max(maxLen, len - 1);
            }
        }
        return maxLen;
    }
}