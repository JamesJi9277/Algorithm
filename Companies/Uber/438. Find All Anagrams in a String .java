//https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() == 0 || p.length() == 0) {
            return res;
        }
        String standard = helper(p);
        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (standard.equals(helper(s.substring(i, i + p.length())))) {
                res.add(i);
            }
        }
        return res;
    }
    private String helper(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }
}


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() == 0 || p.length() == 0) {
            return res;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int left = 0;
        int right = 0;
        int count = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    count++;
                }
            }
            right++;
            while (count == map.size()) {
                char lc = s.charAt(left);
                if (map.containsKey(lc)) {
                    map.put(lc, map.get(lc) + 1);
                    if (map.get(lc) > 0) {
                        count--;
                    }
                }
                if (right - left == p.length()) {
                    res.add(left);
                }
                left++;
            }
        } 
        return res;
    }
}