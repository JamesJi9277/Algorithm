class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<>();
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] t : tickets) {
            map.putIfAbsent(t[0], new PriorityQueue<>());
            map.get(t[0]).offer(t[1]);
        }
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while (!stack.isEmpty()) {
            while (map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty()) {
                stack.push(map.get(stack.peek()).poll());
            }
            res.add(0, stack.pop());
        }
        return res;
    }
}