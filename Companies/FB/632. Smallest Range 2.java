class Solution {
    class Element {
        int row;
        int col;
        int value;
        public Element(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] res = new int[2];
        int index = 0;
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> {
            return a.value - b.value;
        });
        int max = Integer.MIN_VALUE;
        int range = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        for (List<Integer> list : nums) {
            Element element = new Element(index++, 0, list.get(0));
            pq.offer(element);
            max = Math.max(max, element.value);
        }
        while (pq.size() == nums.size()) {
            Element e = pq.poll();
            if (max - e.value < range) {
                range = max - e.value;
                left = e.value;
                right = max;
            }
            if (e.col + 1 < nums.get(e.row).size()) {
                e.col = e.col + 1;
                e.value = nums.get(e.row).get(e.col);
                max = Math.max(max, e.value);
                pq.offer(e);
            }
        }
        return new int[]{left, right};
    }
}