class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        if (nums == null || nums.size() == 0) {
            return new int[2];
        }
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        int range = Integer.MAX_VALUE;
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        int index = 0;
        for (List<Integer> num : nums) {
            Element e = new Element(index++, 0, num.get(0));
            max = Math.max(max, e.val);
            pq.offer(e);
        }
        while (pq.size() == nums.size()) {
            Element temp = pq.poll();
            if (max - temp.val < range) {
                range = max - temp.val;
                left = temp.val;
                right = max;
            }
            if (temp.col + 1 < nums.get(temp.row).size()) {
                temp.col++;
                temp.val = nums.get(temp.row).get(temp.col);
                pq.offer(temp);
            }
            max = Math.max(max, temp.val);
        }
        return new int[]{left, right};
    }
    class Element {
        int row;
        int col;
        int val;
        public Element(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
}