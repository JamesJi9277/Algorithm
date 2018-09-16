class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Element> pq = new PriorityQueue<Element>((a, b) -> (b.count - a.count));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Element e = new Element(entry.getKey(), entry.getValue());
            pq.offer(e);
        }
        List<Integer> list = new ArrayList<>();
        while (k-- > 0) {
            list.add(pq.poll().val);
        }
        return list;
    }
    class Element {
        int val;
        int count;
        public Element() {
            
        }
        public Element(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
}