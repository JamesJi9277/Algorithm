class MagicDictionary {

    Set<String> set;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        set = new HashSet<String>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String s : dict) {
            if (s != null && s.length() != 0)
            set.add(s);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        Iterator<String> iter = set.iterator(); 
        while (iter.hasNext()) {
            String s = iter.next();
            if (canChange(s, word)) {
                return true;
            }
        }
        return false;
    }
    private boolean canChange(String s, String target) {
        if (s.length() != target.length()) {
            return false;
        }
        char[] s1 = s.toCharArray();
        char[] s2 = target.toCharArray();
        int index = 0;
        int diff = 0;
        while (index < s1.length) {
            if (s1[index] != s2[index]) {
                diff++;
            }
            index++;
        }
        return diff == 1;
    }
}
class MagicDictionary {

    Map<String, List<int[]>> map = new HashMap<>();
    /** Initialize your data structure here. */
    public MagicDictionary() {
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String s : dict) {
            for (int i = 0; i < s.length(); i++) {
                String key = s.substring(0, i) + s.substring(i + 1);
                int[] pair = new int[] {i, s.charAt(i)};
                
                List<int[]> val = map.getOrDefault(key, new ArrayList<int[]>());
                val.add(pair);
                
                map.put(key, val);
            }
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for (int i = 0; i < word.length(); i++) {
            String key = word.substring(0, i) + word.substring(i + 1);
            if (map.containsKey(key)) {
                for (int[] pair : map.get(key)) {
                    if (pair[0] == i && pair[1] != word.charAt(i)) return true;
                }
            }
        }
        return false;
    }
}