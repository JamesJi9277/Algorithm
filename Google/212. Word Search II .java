class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        if (board == null || board.length == 0 || board[0].length == 0) {
            return res;
        }
        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }
        boolean[][] isUsed = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                helper(board, i, j, "", isUsed, trie, res);
            }
        }
        return res;
    }
    
    private void helper(char[][] board, int i, int j, String temp, boolean[][] isUsed, Trie trie, List<String> res) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || isUsed[i][j]) {
            return;
        }
        temp += board[i][j];
        if(!trie.startWith(temp)) {
            return;
        }
        if (trie.contains(temp)) {
            if (!res.contains(temp)) {
                res.add(temp);
            }
        }
        isUsed[i][j] = true;
        helper(board, i + 1, j, temp, isUsed, trie, res);
        helper(board, i - 1, j, temp, isUsed, trie, res);
        helper(board, i, j + 1, temp, isUsed, trie, res);
        helper(board, i, j - 1, temp, isUsed, trie, res);
        isUsed[i][j] = false;
    }
    
    class TrieNode {
        char c;
        boolean isWord;
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
        public TrieNode(char c) {
            this.c = c;
            children = new TrieNode[26];
            isWord = false;
        }
    }
    class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
        public Trie(TrieNode root) {
            this.root = root;
        }
        public void add(String s) {
            TrieNode temp = root;
            if (s == null || s.length() == 0) {
                return;
            }
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (temp.children[c - 'a'] == null) {
                    temp.children[c - 'a'] = new TrieNode(c);
                }
                temp = temp.children[c - 'a'];
            }
            temp.isWord = true;
        }
        
        public boolean startWith(String s) {
            if (s == null || s.length() == 0) {
                return false;
            }
            TrieNode temp = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (temp.children[c - 'a'] == null) {
                    return false;
                } else {
                    temp = temp.children[c - 'a'];
                }
            }
            return true;
        }
        public boolean contains(String s) {
            if (s == null || s.length() == 0) {
                return false;
            }
            TrieNode temp = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (temp.children[c - 'a'] == null) {
                    return false;
                } else {
                    temp = temp.children[c - 'a'];
                }
            }
            return temp.isWord;
        }
    }
}