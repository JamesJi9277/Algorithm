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
        for (char c : word.toCharArray()) {
            if (temp.children.containsKey(c)) {
                temp = temp.children.get(c);
            } else {
                temp.children.put(c, new TrieNode());
                temp = temp.children.get(c);
            }
        }
        temp.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        TrieNode temp = root;
        return helper(word, temp);
    }
    private boolean helper(String s, TrieNode root) {
        if (s.length() == 0) {
            return root.isWord;
        }
        char c = s.charAt(0);
        s = s.substring(1);
        boolean found = false;
        if (c == '.') {
            for (Map.Entry<Character, TrieNode> entry : root.children.entrySet()) {
                found |= helper(s, entry.getValue());
            }
        } else if (root.children.containsKey(c)) {
            found = helper(s, root.children.get(c));
        } else {
            return false;
        }
        return found;
    }
}
class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;
    public TrieNode() {
        this.isWord = false;
        children = new HashMap<>();
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */