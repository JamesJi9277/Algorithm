class WordDictionary {

    class TrieNode {
        char c;
        TrieNode[] children;
        boolean isWord;
        public TrieNode() {
            this.isWord = false;
            this.children = new TrieNode[26];
        }
        public TrieNode(char c) {
            this.c = c;
            this.isWord = false;
            this.children = new TrieNode[26];
        }
    }
    /** Initialize your data structure here. */
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
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
        if (word == null || word.length() == 0) {
            return false;
        }
        TrieNode temp = root;
        return helper(temp, word);
    }
    private boolean helper(TrieNode root, String s) {
        if (root == null) {
            return false;
        }
        if (s.length() == 0) {
            return root.isWord;
        }
        boolean res = false;
        char c = s.charAt(0);
        s = s.substring(1);
        if (c == '.') {
            for (TrieNode node : root.children) {
                if (node != null) {
                    res |= helper(node, s);
                }
            }
        } else {
            res |= helper(root.children[c - 'a'], s);
        }
        return res;
    }
}

class WordDictionary {

    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
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
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        TrieNode temp = root;
        return helper(temp, word);
    }
    private boolean helper(TrieNode root, String s) {
        if (root == null) {
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
                if (entry.getValue() != null) {
                    res |= helper(entry.getValue(), s);
                }
            }
        } else {
            res |= helper(root.children.get(c), s);
        }
        return res;
    }
    class TrieNode {
        Character key;
        Map<Character, TrieNode> children;
        boolean isWord;
        public TrieNode() {
            this.children = new HashMap<>();
            this.isWord = false;
        }
        public TrieNode(char key) {
            this.key = key;
            this.children = new HashMap<>();
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