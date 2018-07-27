class Trie {

    class TrieNode {
        char c;
        Map<Character, TrieNode> children;
        boolean isWord;
        public TrieNode() {
            children = new HashMap<>();
            isWord = false;
        }
        public TrieNode(char c) {
            this.c = c;
            children = new HashMap<>();
            isWord = false;
        }
    }
    /** Initialize your data structure here. */
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!temp.children.containsKey(c)) {
                temp.children.put(c, new TrieNode(c));
            }
            temp = temp.children.get(c);
        }
        temp.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode temp = root;
        if (word == null || word.length() == 0) {
            return false;
        }
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!temp.children.containsKey(c)) {
                return false;
            }
            temp = temp.children.get(c);
        }
        return temp.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        if (prefix == null || prefix.length() == 0) {
            return false;
        }
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!temp.children.containsKey(c)) {
                return false;
            }
            temp = temp.children.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */