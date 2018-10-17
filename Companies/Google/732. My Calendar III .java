class MyCalendarThree {

    class Node {
        boolean isStart;
        int time;
        public Node(boolean isStart, int time) {
            this.isStart = isStart;
            this.time = time;
        }
    }
    private List<Node> list;
    public MyCalendarThree() {
        list = new ArrayList<>();
    }
    
    public int book(int start, int end) {
        list.add(new Node(true, start));
        list.add(new Node(false, end));
        return helper(list);
    }
    private int helper(List<Node> list) {
        Collections.sort(list, (a, b) -> {
            if (a.time != b.time) {
                return a.time - b.time;
            } else {
                return a.isStart ? 1 : -1;
            }
        });
        int max = 0;
        int temp = 0;
        for (Node n : list) {
            if (n.isStart) {
                temp++;
                max = Math.max(max, temp);
            } else {
                temp--;
            }
        }
        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */