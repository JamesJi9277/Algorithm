class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        wordList.add(beginWord);
        Map<String, List<String>> neighbors = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        List<String> temp = new ArrayList<>();
        for (String s : wordList) {
            set.add(s);
            neighbors.put(s, new ArrayList<>());
        }
        temp.add(beginWord);
        bfs(beginWord, endWord, set, neighbors, distance);
        dfs(beginWord, endWord, set, neighbors, distance, res, temp);

        return res;
    }
    private void dfs(String begin, String end, Set<String> set, Map<String, List<String>> neighbors, Map<String, Integer> distance, List<List<String>> res, List<String> temp) {
        if (begin.equals(end)) {
            res.add(new ArrayList<String>(temp));
            return;
        }
        int level = distance.get(begin);
        for (String next : neighbors.get(begin)) {
            if (distance.get(next) - 1 == level) {
                temp.add(next);
                dfs(next, end, set, neighbors, distance, res, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
    private void bfs(String begin, String end, Set<String> set, Map<String, List<String>> neighbors, Map<String, Integer> distance) {
        Queue<String> queue = new LinkedList<>();
        distance.put(begin, 0);
        queue.offer(begin);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String temp = queue.poll();
                if (temp.equals(end)) {
                    return;
                }
                int level = distance.get(temp);
                List<String> neighbor = helper(temp, set);
                for (String next : neighbor) {
                    neighbors.get(temp).add(next);
                    if (!distance.containsKey(next)) {
                        distance.put(next, level + 1);
                        queue.offer(next);
                    }
                }
            }
        }
    }
    private List<String> helper(String s, Set<String> set) {
        List<String> res = new ArrayList<>();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < 26; j++) {
                char c = array[i];
                if ((char)('a' + j) == c) {
                    continue;
                }
                array[i] = (char)('a' + j);
                if (set.contains(new String(array))) {
                    res.add(new String(array));
                }
                array[i] = c;
            }
        }
        return res;
    }
}