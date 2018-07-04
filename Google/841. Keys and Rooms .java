class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0) {
            return false;
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(0);
        visited.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int temp = queue.poll();
                for (int j : rooms.get(temp)) {
                    if (!visited.contains(j)) {
                        queue.offer(j);
                        visited.add(j);
                    }
                }
            }
        }
        return visited.size() == rooms.size();
    }
}