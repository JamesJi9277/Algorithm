class PStack {
	private int size;
	private int ele;
	private PStack prev;
	public PStack(PStack prev, int ele, int size) {
		this.prev = prev;
		this.ele = ele;
		this.size = size;
	}
	public PStack() {
		this.prev = this;
		this.size = 0;
	}
	public PStack pop() {
		return this.prev;
	}
	public PStack push(int ele) {
		return new PStack(this, ele, this.size + 1);
	}
	public int peek() {
		return this.ele;
	}
	public int getSize() {
		return this.size;
	}
}