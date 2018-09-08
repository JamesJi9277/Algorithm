class Solution {
    public String reorganizeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) > (s.length() + 1) / 2) {
                return "";
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        StringBuffer sb = new StringBuffer();
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            if (sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)) {
                sb.append((char)first[0]);
                first[1]--;
                if (first[1] > 0) {
                    pq.offer(first);
                }
            } else {
                int[] second = pq.poll();
                sb.append((char)second[0]);
                if (--second[1] > 0) {
                    pq.offer(second);
                }
                pq.offer(first);
            }
        }
        return sb.toString();
    }
}