class WordDictionary {

    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (temp.children[c - 'a'] == null) {
                temp.children[c - 'a'] = new TrieNode(c);
            }
            temp = temp.children[c - 'a'];
        }
        temp.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(root, word);
    }
    private boolean helper(TrieNode root, String word) {
        if (root == null) {
            return false;
        }
        if (word.length() == 0) {
            return root.isWord;
        }
        String s = word.substring(1);
        char c = word.charAt(0);
        boolean res = false;
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (root.children[i] != null) {
                    res |= helper(root.children[i], s);
                }
            }
        } else {
            res |= helper(root.children[c - 'a'], s);
        }
        return res;
    }
    
    class TrieNode {
        char c;
        TrieNode[] children;
        boolean isWord;
        public TrieNode () {
            this.children = new TrieNode[26];
            this.isWord = false;
        }
        public TrieNode (char c) {
            this.c = c;
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */