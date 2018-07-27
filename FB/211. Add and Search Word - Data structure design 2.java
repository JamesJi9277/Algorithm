class WordDictionary {

    class TrieNode {
        char c;
        Map<Character, TrieNode> children;
        boolean isWord;
        public TrieNode() {
            this.children = new HashMap<>();
            this.isWord = false;
        }
        public TrieNode(char c) {
            this.c = c;
            this.children = new HashMap<>();
            this.isWord = false;
        }
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode temp = root;
        if (word == null || word.length() == 0) {
            return;
        }
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!temp.children.containsKey(c)) {
                temp.children.put(c, new TrieNode(c));
            }
            temp = temp.children.get(c);
        }
        temp.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode temp = root;
        if (word == null || word.length() == 0) {
            return false;
        }
        return helper(temp, word);
    }
    private boolean helper(TrieNode root, String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return root.isWord;
        }
        boolean res = false;
        char c = s.charAt(0);
        s = s.substring(1);
        if (c == '.') {
            for (Map.Entry<Character, TrieNode> entry : root.children.entrySet()) {
                res |= helper(entry.getValue(), s);
            }
        } else if (root.children.containsKey(c)) {
            res |= helper(root.children.get(c), s);
        } else {
            return false;
        }
        return res;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */