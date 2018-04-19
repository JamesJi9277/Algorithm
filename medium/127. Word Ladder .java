class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        int length = 1;
        if (wordList.contains(beginWord)) {
            wordList.remove(beginWord);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                for (int j = 0; j < s.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        String temp = replace(s, j, c);
                        if (wordList.contains(temp) && temp.equals(endWord)) {
                            return length + 1;
                        }
                        if (wordList.contains(temp)) {
                            wordList.remove(temp);
                            queue.offer(temp);
                        }
                    }
                }
            }
            length++;
        }
        return 0;
    }
    private String replace(String s, int index, char c) {
        StringBuffer sb = new StringBuffer(s);
        sb.setCharAt(index, c);
        return sb.toString();
    }
}