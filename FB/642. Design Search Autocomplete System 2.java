class AutocompleteSystem {

    class TrieNode {
        Map<Character, TrieNode> children;
        Map<String, Integer> counts;
        boolean isWord;
        public TrieNode() {
            children = new HashMap<>();
            counts = new HashMap<>();
            isWord = false;
        }
    }
    class Pair {
        String s;
        int c;
        public Pair(String s, int c) {
            this.s = s;
            this.c = c;
        }
    }
    TrieNode root;
    String prefix;
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";
        
        for (int i = 0; i < sentences.length; i++) {
            add(sentences[i], times[i]);
        }
    }
    private void add(String s, int count) {
        TrieNode temp = root;
        for (char c : s.toCharArray()) {
            if (!temp.children.containsKey(c)) {
                temp.children.put(c, new TrieNode());
            }
            temp = temp.children.get(c);
            temp.counts.put(s, temp.counts.getOrDefault(s, 0) + count);
        }
        temp.isWord = true;
    }
    
    public List<String> input(char c) {
        if (c == '#') {
            add(prefix, 1);
            prefix = "";
            return new ArrayList<String>();
        }
        prefix += c;
        TrieNode temp = root;
        for (char cc : prefix.toCharArray()) {
            if (!temp.children.containsKey(cc)) {
                return new ArrayList<String>();
            }
            temp = temp.children.get(cc);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.c == b.c ? a.s.compareTo(b.s) : b.c - a.c));
        for (String s : temp.counts.keySet()) {
            pq.offer(new Pair(s, temp.counts.get(s)));
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
            res.add(pq.poll().s);
        }
        return res;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */