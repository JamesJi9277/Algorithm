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

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */