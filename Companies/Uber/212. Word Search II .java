class Solution {
    class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }
        public void insert(String s) {
            TrieNode temp = root;
            for (char c : s.toCharArray()) {
                if (!temp.children.containsKey(c)) {
                    temp.children.put(c, new TrieNode());
                }
                temp = temp.children.get(c);
            }
            temp.isWord = true;
        }
        public boolean search(String s) {
            TrieNode temp = root;
            for (char c : s.toCharArray()) {
                if (!temp.children.containsKey(c)) {
                    temp.children.put(c, new TrieNode());
                }
                temp = temp.children.get(c);
            }
            return temp.isWord;
        }
        public boolean startWith(String s) {
            TrieNode temp = root;
            for (char c : s.toCharArray()) {
                if (!temp.children.containsKey(c)) {
                    temp.children.put(c, new TrieNode());
                }
                temp = temp.children.get(c);
            }
            return true;
        }
    }
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;
        public TrieNode() {
            this.children = new HashMap<>();
            this.isWord = false;
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
            return res;
        }
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                helper(res, trie, board, visited, i, j, sb);
            }
        }
        return res;
    }
    private void helper(List<String> res, Trie trie, char[][] board, boolean[][] visited, int row, int col, StringBuffer sb) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]) {
            return;
        }
        sb.append(board[row][col]);
        if (!trie.startWith(new String(sb))) {
            return;
        }
        if (trie.search(new String(sb)) && !res.contains(new String(sb))) {
            res.add(new String(sb));
        }
        visited[row][col] = true;
        helper(res, trie, board, visited, row + 1, col, sb);
        helper(res, trie, board, visited, row - 1, col, sb);
        helper(res, trie, board, visited, row, col + 1, sb);
        helper(res, trie, board, visited, row, col - 1, sb);
        sb.deleteCharAt(sb.length() - 1);
        visited[row][col] = false;
    }
}