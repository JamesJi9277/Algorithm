class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            int p1 = ppid.get(i);
            int p2 = pid.get(i);
            map.putIfAbsent(p1, new ArrayList<>());
            map.get(p1).add(p2);
        }
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(kill);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int temp = queue.poll();
                res.add(temp);
                if (map.containsKey(temp)) {
                    queue.addAll(map.get(temp));
                }
            }
        }
        return res;
    }
}