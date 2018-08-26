class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0) {
            return res;
        }
        Trie trie = new Trie();
        for (String s : words) {
            trie.add(s);
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                helper(board, i, j, "", visited, trie, res);
            }
        }
        return res;
    }
    private void helper(char[][] board, int row, int col, String temp, boolean[][] visited, Trie trie, List<String> res) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]) {
            return;
        }
        temp += board[row][col];
        if (!trie.startWith(temp)) {
            return;
        }
        if (trie.contains(temp) && !res.contains(temp)) {
            res.add(temp);
        }
        visited[row][col] = true;
        helper(board, row + 1, col, temp, visited, trie, res);
        helper(board, row - 1, col, temp, visited, trie, res);
        helper(board, row, col + 1, temp, visited, trie, res);
        helper(board, row, col - 1, temp, visited, trie, res);
        visited[row][col] = false;
    }
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;
        public TrieNode() {
            this.children = new HashMap<>();
            this.isWord = false;
        }
    }
    class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
        public void add(String s) {
            TrieNode temp = root;
            for (char c : s.toCharArray()) {
                if (!temp.children.containsKey(c)) {
                    temp.children.put(c, new TrieNode());
                }
                temp = temp.children.get(c);
            }
            temp.isWord = true;
        }
        public boolean contains(String s) {
            TrieNode temp = root;
            for (char c : s.toCharArray()) {
                if (!temp.children.containsKey(c)) {
                    return false;
                }
                temp = temp.children.get(c);
            }
            return temp.isWord;
        }
        public boolean startWith(String s) {
            TrieNode temp = root;
            for (char c : s.toCharArray()) {
                if (!temp.children.containsKey(c)) {
                    return false;
                }
                temp = temp.children.get(c);
            }
            return true;
        }
    }
}