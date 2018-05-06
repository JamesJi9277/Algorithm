// 堆是建立最小堆，但是我要根据val从大到小的顺序来放入这个堆
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        Comp cmp = new Comp();
        PriorityQueue<StringNode> pq = new PriorityQueue<>(k, cmp);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String word : words) {
            if(map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            }
            else {
                map.put(word, 1);
            }
        }
        for (String s : map.keySet()) {
            StringNode node = new StringNode(s, map.get(s));
            if (pq.size() < k) {
                pq.offer(node);
            } else {
                if (cmp.compare(node, pq.peek()) > 0) {
                    pq.poll();
                    pq.offer(node);
                }
            }
        }
        while (!pq.isEmpty()) {
            res.add(0, pq.poll().val);
        }
        return res;
        
    }
    private class Comp implements Comparator<StringNode> {
        public int compare(StringNode e1, StringNode e2) {
            if(e1.num > e2.num) {
                return 1;
            }
            else if(e1.num < e2.num) {
                return -1;
            }
            else {
                return e2.val.compareTo(e1.val);
            }
        }
    }
}
class StringNode {
    String val;
    int num;
    public StringNode (String val, int num) {
        this.val = val;
        this.num = num;
    }
}