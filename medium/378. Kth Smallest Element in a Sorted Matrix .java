class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int res = 0;
        PriorityQueue<Node> pq = new PriorityQueue<Node>(k);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                pq.offer(new Node(i, j, matrix[i][j]));
            }
        }
        while (!pq.isEmpty()) {
            res = pq.poll().val;
        }
        return res;
    }
}

class Node implements Comparable<Node> {
    int x;
    int y;
    int val;
    
    public Node() {
        
    }
    
    public Node(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
    
    @Override
    public int compareTo(Node n2) {
        return this.val - n2.val;
    }
}


public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        for(int j = 0; j <= n-1; j++) pq.offer(new Tuple(0, j, matrix[0][j]));
        for(int i = 0; i < k-1; i++) {
            Tuple t = pq.poll();
            if(t.x == n-1) continue;
            pq.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
        }
        return pq.poll().val;
    }
}

class Tuple implements Comparable<Tuple> {
    int x, y, val;
    public Tuple (int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
    
    @Override
    public int compareTo (Tuple that) {
        return this.val - that.val;
    }
}