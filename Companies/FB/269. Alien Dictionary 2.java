class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        Map<Character, Integer> indegree = new HashMap<>();
        Map<Character, ArrayList<Character>> map = new HashMap<>();
        //这一题必须先要在外面对indegree进行初始化
        // 因为我在比较的时候是找到第一个不等于的
        // 所以会漏掉一些字母没有被初始化以及漏掉indegree的判断
        for (String s : words) {
            for (int i = 0; i < s.length(); i++) {
                indegree.put(s.charAt(i), 0);
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
                map.putIfAbsent(c1, new ArrayList<Character>());
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
            char c = queue.poll();
            sb.append(c);
            if (map.get(c) == null) {
                continue;
            }
            for (Character neighbor : map.get(c)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return sb.length() == indegree.size() ? sb.toString() : "";
    }
}