class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        for (String s : words) {
            if (isValid(s, S)) {
                count++;
            }
        }
        return count;
    }
    private boolean isValid(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (s.length() > t.length()) {
            return false;
        }
        int index1 = 0;
        int index2 = 0;
        while (index2 < t.length()) {
            if (t.charAt(index2++) == s.charAt(index1)) {
                index1++;
                if (index1 == s.length()) {
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
        Map<Character, Deque<String>> map = new HashMap<Character, Deque<String>>();
        for (char c = 'a'; c <= 'z'; c++) {
            map.put(c, new LinkedList<String>());
        }
        for (String s : words) {
            map.get(s.charAt(0)).addLast(s);
        }
    
        for (char c : S.toCharArray()) {
            Deque<String> queue = map.get(c);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.removeFirst();
                if (word.length() == 1) {
                    count++;
                } else {
                    map.get(word.charAt(1)).addLast(word.substring(1));
                }
            }
        }
        return count;
    }
}


class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        HashMap<Character, Deque<String>> map = new HashMap<Character, Deque<String>>();
        if (words == null || words.length == 0) {
            return 0;
        }
        int count = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            map.put(c, new LinkedList<String>());
        }
        for (String s : words) {
            map.get(s.charAt(0)).addLast(s);
        }
        for (char c : S.toCharArray()) {
            Deque<String> queue = map.get(c);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.removeFirst();
                if (word.length() == 1) {
                    count++;
                } else {
                    map.get(word.charAt(1)).addLast(word.substring(1));
                }
            }
        }
        return count;
    }
}