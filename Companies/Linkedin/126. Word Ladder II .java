class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        Map<String, List<String>> neighborsMap = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        List<String> temp = new ArrayList<>();
        dict.add(beginWord);
        bfs(beginWord, endWord, dict, neighborsMap, distance);
        dfs(beginWord, endWord, dict, neighborsMap, distance, temp, res);
        return res;
    }
    private void bfs(String start, String end, Set<String> dict, Map<String, List<String>> neighborsMap, Map<String, Integer> distance) {
        for (String s : dict) {
            neighborsMap.put(s, new ArrayList<String>());
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distance.put(start, 0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                int curDistance = distance.get(cur);
                List<String> neighbors = getNeighbors(cur, dict);
                for (String neighbor : neighbors) {
                    neighborsMap.get(cur).add(neighbor);
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, curDistance + 1);
                        if (end.equals(neighbor)) {
                            break;
                        } else {
                            queue.offer(neighbor);
                        }
                    }
                }
            }
        }
    }
    private List<String> getNeighbors(String s, Set<String> dict) {
        List<String> res = new ArrayList<>();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                char temp = array[i];
                array[i] = c;
                if (dict.contains(new String(array))) {
                    res.add(new String(array));
                }
                array[i] = temp;
            }
        }
        return res;
    }
    private void dfs(String cur, String end, Set<String> dict, Map<String, List<String>> neighborsMap, Map<String, Integer> distance, List<String> temp, List<List<String>> res) {
        temp.add(cur);
        if (end.equals(cur)) {
            res.add(new ArrayList<String>(temp));
        } else {
            for (String next : neighborsMap.get(cur)) {
                if (distance.get(next) == distance.get(cur) + 1) {
                    dfs(next, end, dict, neighborsMap, distance, temp, res);
                }
            }
        }
        temp.remove(temp.size() - 1);
    }
}