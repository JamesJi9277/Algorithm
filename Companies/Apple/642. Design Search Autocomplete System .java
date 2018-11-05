class AutocompleteSystem {

    class TrieNode {
        Map<Character, TrieNode> children;
        Map<String, Integer> freq;
        public TrieNode() {
            children = new HashMap<>();
            freq = new HashMap<>();
        }
        
    }
    class Pair {
        String key;
        int count;
        public Pair(String key, int count) {
            this.key = key;
            this.count = count;
        }
    }
    String pre;
    TrieNode root;
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        pre = "";
        for (int i = 0; i < sentences.length; i++) {
            add(sentences[i], times[i]);
        }
    }
    public void add(String s, int count) {
        TrieNode temp = root;
        for (char c : s.toCharArray()) {
            if (!temp.children.containsKey(c)) {
                temp.children.put(c, new TrieNode());
            }
            temp = temp.children.get(c);
            temp.freq.put(s, temp.freq.getOrDefault(s, 0) + count);
        }
    }
    
    public List<String> input(char c) {
        if (c == '#') {
            add(pre, 1);
            pre = "";
            return new ArrayList<String>();
        }
        pre += c;
        TrieNode temp = root;
        for (char c1 : pre.toCharArray()) {
            if (!temp.children.containsKey(c1)) {
                return new ArrayList<String>();
            }
            temp = temp.children.get(c1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.count == b.count) {
                return a.key.compareTo(b.key);
            } else {
                return b.count - a.count;
            }
        });
        for (Map.Entry<String, Integer> entry : temp.freq.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        List<String> res = new ArrayList<>();
        while (!pq.isEmpty() && res.size() < 3) {
            res.add(pq.poll().key);
        }
        return res;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */