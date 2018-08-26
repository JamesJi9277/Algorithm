class Solution {
    class Element {
        int row;
        int col;
        int value;
        public Element() {
            
        }
        public Element(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        if (nums == null || nums.size() == 0) {
            return new int[2];
        }
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> (a.value - b.value));
        int index = 0;
        int max = 0;
        for (List<Integer> num : nums) {
            Element e = new Element(index++, 0, num.get(0));
            pq.offer(e);
            max = Math.max(max, e.value);
        }
        int left = 0;
        int right = 0;
        int range = Integer.MAX_VALUE;
        while (pq.size() == nums.size()) {
            Element temp = pq.poll();
            if (max - temp.value < range) {
                left = temp.value;
                right = max;
                range = max - temp.value;
            }
            if (temp.col + 1 < nums.get(temp.row).size()) {
                temp.col = temp.col + 1;
                temp.value = nums.get(temp.row).get(temp.col);
                pq.offer(temp);
            }
            max = Math.max(max, temp.value);
        }
        return new int[]{left, right};
    }
}