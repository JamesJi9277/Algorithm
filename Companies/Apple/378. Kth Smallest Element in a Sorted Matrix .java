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
        for (int i = 0; i < matrix.length; i++) {
            pq.offer(new Node(i, 0, matrix[i][0]));
        }
        while (--k > 0 && !pq.isEmpty()) {
            Node temp = pq.poll();
            if (temp.col + 1 < matrix.length) {
                pq.offer(new Node(temp.row, temp.col + 1, matrix[temp.row][temp.col + 1]));
            }
        }
        return pq.peek().val;
    }
}

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (k == 1) {
            return matrix[0][0];
        }
        int n = matrix.length;
        if (k == n * n) {
            return matrix[n - 1][n - 1];
        }
        int start = matrix[0][0];
        int end = matrix[n - 1][n - 1];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int count = countLessEqual(matrix, mid);
            if (count < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }
    private int countLessEqual(int[][] matrix, int target) {
        int count = 0;
        int x = matrix.length - 1;
        int y = 0;
        while (x >= 0 && y < matrix.length) {
            if (matrix[x][y] <= target) {
                count += (x + 1);
                y++;
            } else {
                x--;
            }
        }
        return count;
    }

}