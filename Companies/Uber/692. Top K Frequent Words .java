class Solution {
    class Node {
        String key;
        int count;
        public Node(String key, int count) {
            this.key = key;
            this.count = count;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.count == b.count) {
                return a.key.compareTo(b.key);
            } else {
                return b.count - a.count;
            }
        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Node node = new Node(entry.getKey(), entry.getValue());
            pq.offer(node);
        }
        while (!pq.isEmpty() && res.size() != k) {
            res.add(pq.poll().key);
        }
        return res;
    }
}