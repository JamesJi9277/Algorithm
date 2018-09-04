class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        Map<Character, List<Character>> map = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for (String s : words) {
            for (int i = 0; i < s.length(); i++) {
                map.putIfAbsent(s.charAt(i), new ArrayList<Character>());
                indegree.putIfAbsent(s.charAt(i), 0);
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            for (int j = 0; j < Math.min(s1.length(), s2.length()); j++) {
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                if (c1 == c2) {
                    continue;
                }
                map.get(c1).add(c2);
                indegree.put(c2, indegree.get(c2) + 1);
                break;
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                char temp = queue.poll();
                sb.append(temp);
                for (char neighbor : map.get(temp)) {
                    indegree.put(neighbor, indegree.get(neighbor) - 1);
                    if (indegree.get(neighbor) == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return sb.length() == map.size() ? sb.toString() : "";
    }
}