class Solution {
    class Element {
        String key;
        int count;
        public Element(String key, int count) {
            this.key = key;
            this.count = count;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> {
            if (a.count == b.count) {
                return a.key.compareTo(b.key);
            } else {
                return b.count - a.count;
            }
        });
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            Element e = new Element(entry.getKey(), entry.getValue());
            pq.offer(e);
        }
        while(k-- > 0) {
            res.add(pq.poll().key);
        }
        return res;
    }
}