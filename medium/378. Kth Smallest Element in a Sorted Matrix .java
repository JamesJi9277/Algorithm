class Solution {
    class Node {
        int row;
        int col;
        int val;
        public Node(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>((n1, n2) -> {
            return n1.val - n2.val;
        });
        for (int i = 0; i < matrix[0].length; i++) {
            pq.offer(new Node(0, i, matrix[0][i]));
        }
        while (--k > 0 && !pq.isEmpty()) {
            Node temp = pq.poll();
            if (temp.row + 1 < matrix.length) {
                pq.offer(new Node(temp.row + 1, temp.col, matrix[temp.row + 1][temp.col]));
            }
        }
        return pq.peek().val;
    }
}