class Node {
	int index;
	int val;
	int prime;
	Node(int index, int val, int prime) {
		this.index = index;
		this.val = val;
		this.prime = prime;
	}
}
public class Solution {
	private class NodeComp implements Comparator<Node> {
		public int compare(Node n1, Node n2) {
			return n1.val - n2.val;
		}
	}
	public int nthSuperUglyNumber(int n, int[] primes) {
		if(primes == null || primes.length == 0 || n < 0) {
			return 0;
		}
		NodeComp cmp = new NodeComp();
		int[] res = new int[n];
		res[0] = 1;
		PriorityQueue<Node> heap = new PriorityQueue<Node>(cmp);
		for(int i = 0; i < primes.length; i++) {
			heap.offer(new Node(0, primes[i], primes[i]));
		}
		for(int i = 1; i < n; i++) {
			Node cur = heap.peek();
			res[i] = cur.val;
			while(!heap.isEmpty() && heap.peek().val == res[i]) {
				cur = heap.poll();
				cur.val = res[++cur.index] * cur.prime;
				heap.offer(cur);
			}
		}
		return res[n - 1];
	}
}