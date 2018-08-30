class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        if (nums == null || nums.size() == 0) {
            return new int[2];
        }
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        int range = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int index = 0;
        int left = 0;
        int right = 0;
        for (List<Integer> list : nums) {
            Element e = new Element(index++, 0, list.get(0));
            pq.offer(e);
            max = Math.max(max, e.val);
        }
        while (pq.size() == nums.size()) {
            Element temp = pq.poll();
            // 这里只是做到每一个list提供一个数，然后去更新range
            // max保证了至少每个list有一个数会在其中
            if (max - temp.val < range) {
                range = max - temp.val;
                left = temp.val;
                right = max;
            }
            if (temp.col + 1 < nums.get(temp.row).size()) {
                temp.val = nums.get(temp.row).get(temp.col + 1);
                temp.col = temp.col + 1;
                pq.offer(temp);
            }
            max = Math.max(max, temp.val);
        }
        return new int[]{left, right};
    }
    // add element in each row
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