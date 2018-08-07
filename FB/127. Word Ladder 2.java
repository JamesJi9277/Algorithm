class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int minLen = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            minLen++;
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(endWord)) {
                    // 只有满足这种条件才会返回满足条件的minLen
                    // 不然就直接返回0就好了，代表不存在
                    return minLen;
                }
                char[] array = cur.toCharArray();
                for (int j = 0; j < array.length; j++) {
                    for (int k = 0; k < 26; k++) {
                        char c1 = array[j];
                        array[j] = (char)('a' + k);
                        String s1 = new String(array);
                        if (!visited.contains(s1) && wordList.contains(s1)) {
                            visited.add(s1);
                            queue.offer(s1);
                        }
                        array[j] = c1;
                    }
                }
            }
        }
        return 0;
    }
}