class Trie {

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;
        public TrieNode() {
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
        for (char c : word.toCharArray()) {
            if (!temp.children.containsKey(c)) {
                temp.children.put(c, new TrieNode());
            }
            temp = temp.children.get(c);
        }
        temp.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        TrieNode temp = root;
        for (char c : word.toCharArray()) {
            if (!temp.children.containsKey(c)) {
                return false;
            }
            temp = temp.children.get(c);
        }
        return temp.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return false;
        }
        TrieNode temp = root;
        for (char c : prefix.toCharArray()) {
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