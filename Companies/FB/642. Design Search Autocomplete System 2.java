class AutocompleteSystem {

    class TrieNode {
        boolean isWord;
        Map<Character, TrieNode> children;
        Map<String, Integer> freq;
        public TrieNode() {
            this.isWord = false;
            this.children = new HashMap<>();
            this.freq = new HashMap<>();
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
    StringBuffer sb;
    TrieNode root;
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        sb = new StringBuffer();
        for (int i = 0; i < times.length; i++) {
            update(root, sentences[i], times[i]);
        }
    }
    
    public void update(TrieNode root, String s, int time) {
        TrieNode temp = root;
        for (char c : s.toCharArray()) {
            temp.children.putIfAbsent(c, new TrieNode());
            temp = temp.children.get(c);
            temp.freq.put(s, temp.freq.getOrDefault(s, 0) + time);
        }
        temp.isWord = true;
    }
    
    public List<String> input(char c) {
        if (c == '#') {
            update(root, sb.toString(), 1);
            sb = new StringBuffer();
            return new ArrayList<String>();
        }
        sb.append(c);
        // search
        TrieNode temp = root;
        for (char c1 : sb.toString().toCharArray()) {
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
        while (res.size() < 3 && !pq.isEmpty()) {
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