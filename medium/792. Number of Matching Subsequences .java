class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        for (String word : words) {
            if (isSub(word, S)) {
                count++;
            }
        }
        return count;
    }
    private boolean isSub(String s1, String s2) {
        int index = 0;
        for (int i = 0; i < s2.length(); i++) {
            if (s1.charAt(index) == s2.charAt(i)) {
                index++;
                if (index == s1.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}

class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            map.putIfAbsent(c, new ArrayList<Integer>());
            map.get(c).add(i);
        }
        for (String word : words) {
            if (valid(map, word)) {
                count++;
            }
        }
        return count;
    }
    private boolean valid(Map<Character, List<Integer>> map, String s) {
        int prev = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                return false;
            }
            int index = helper(map.get(c), prev + 1);
            if (index == -1) {
                return false;
            } else {
                prev = index;
            }
        }
        return true;
    }
    private int helper(List<Integer> list, int target) {
        int start = 0;
        int end = list.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (list.get(start) >= target) {
            return list.get(start);
        } else if (list.get(end) >= target) {
            return list.get(end);
        } else {
            return -1;
        }
    }
}