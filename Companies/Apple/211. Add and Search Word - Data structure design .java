class WordDictionary {

    /** Initialize your data structure here. */
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;
        public TrieNode() {
            this.children = new HashMap<>();
            this.isWord = false;
        }
    }
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode temp = root;
        for (char c : word.toCharArray()) {
            if (!temp.children.containsKey(c)) {
                temp.children.put(c, new TrieNode());
            }
            temp = temp.children.get(c);
        }
        temp.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode temp = root;
        return helper(word, temp);
    }
    private boolean helper(String word, TrieNode root) {
        if (word.length() == 0) {
            return root.isWord;
        }
        char c = word.charAt(0);
        word = word.substring(1);
        boolean res = false;
        if (c != '.' && root.children.containsKey(c)) {
            res |= helper(word, root.children.get(c));
        } else if (c == '.') {
            for (Map.Entry<Character, TrieNode> entry : root.children.entrySet()) {
                res |= helper(word, entry.getValue());
            }
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