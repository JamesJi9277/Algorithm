class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        HashMap<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
        Map<Character, Integer> indegree = new HashMap<Character, Integer>();
        StringBuffer sb = new StringBuffer();
        for (String s : words) {
            for (int i = 0; i < s.length(); i++) {
                indegree.put(s.charAt(i), 0);
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];
            for (int j = 0; j < Math.min(cur.length(), next.length()); j++) {
                char c1 = cur.charAt(j);
                char c2 = next.charAt(j);
                if (c1 == c2) {
                    continue;
                }
                Set<Character> neighbors = map.get(c1);
                if (neighbors == null) {
                    neighbors = new HashSet<Character>();
                }
                if (!neighbors.contains(c2)) {
                    neighbors.add(c2);
                    map.put(c1, neighbors);
                    indegree.put(c2, indegree.get(c2) + 1);
                }
                break;
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }
        while (!queue.isEmpty()) {
            char cur = queue.poll();
            sb.append(cur);
            Set<Character> neighbors = map.get(cur);
            if (neighbors == null) {
                continue;
            }
            for (Character neighbor : neighbors) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return sb.length() == indegree.size() ? sb.toString() : "";
    }
}