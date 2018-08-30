class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < wall.size(); i++) {
            int n = 0;
            for (int j = 0; j < wall.get(i).size() - 1; j++) {
                n += wall.get(i).get(j);
                map.put(n, map.getOrDefault(n, 0) + 1);
                if (map.get(n) > max) {
                    max = map.get(n);
                }
            }
        }
        return wall.size() - max;
    }
}