class AutocompleteSystem {

    class TrieNode {
        Map<Character, TrieNode> children;
        Map<String, Integer> count;
        boolean isWord;
        public TrieNode() {
            children = new HashMap<>();
            count = new HashMap<>();
            isWord = false;
        }
    }
    class Element {
        String key;
        int count;
        public Element(String key, int count) {
            this.key = key;
            this.count = count;
        }
    }
    String prefix;
    TrieNode root;
    public AutocompleteSystem(String[] sentences, int[] times) {
        prefix = "";
        root = new TrieNode();
        for (int i = 0; i < times.length; i++) {
            insert(sentences[i], times[i]);
        }
    }
    private void insert(String s, int time) {
        TrieNode temp = root;
        for (char c : s.toCharArray()) {
            if (!temp.children.containsKey(c)) {
                temp.children.put(c, new TrieNode());
            }
            temp = temp.children.get(c);
            temp.count.put(s, temp.count.getOrDefault(s, 0) + time);
        }
        temp.isWord = true;
    }
    
    public List<String> input(char c1) {
        List<String> res = new ArrayList<>();
        if (c1 == '#') {
            insert(prefix, 1);
            prefix = "";
        } else {
            prefix += c1;
            TrieNode temp = root;
            for (char c : prefix.toCharArray()) {
                if (!temp.children.containsKey(c)) {
                    return new ArrayList<String>();
                }
                temp = temp.children.get(c);
            }
            PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> {
                if (a.count == b.count) {
                    return a.key.compareTo(b.key);
                } else {
                    return b.count - a.count;
                }
            });
            for (Map.Entry<String, Integer> entry : temp.count.entrySet()) {
                Element e = new Element(entry.getKey(), entry.getValue());
                pq.offer(e);
            }
            for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
                res.add(pq.poll().key);
            }
            return res;
        }
        return res;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */