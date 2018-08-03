class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null || wordList.size() == 0) {
            return 0;
        }
        int steps = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        wordList.remove(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                String temp = queue.poll();
                wordList.remove(temp);
                if (temp.equals(endWord)) {
                    return steps;
                }
                StringBuffer sb = new StringBuffer(temp);
                for (int j = 0; j < sb.length(); j++) {
                    for (int k = 0; k < 26; k++) {
                        char cc = sb.charAt(j);
                        sb.setCharAt(j, (char)('a' + k));
                        String temp1 = new String(sb);
                        if (wordList.contains(temp1)) {
                            queue.offer(temp1);
                        }
                        sb.setCharAt(j, cc);
                    }
                }
            }
        }
        return 0;
    }
}