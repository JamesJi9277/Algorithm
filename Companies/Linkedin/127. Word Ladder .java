class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // find shortest, using BFS to keep current level
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        Set<String> list = new HashSet<>();
        for (String s : wordList) {
            list.add(s);
        }
        int level = 0;
        queue.offer(beginWord);
        set.add(beginWord);
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String temp = queue.poll();
                if (temp.equals(endWord)) {
                    return level;
                } else {
                    char[] array = temp.toCharArray();
                    for (int j = 0; j < array.length; j++) {
                        for (int k = 0; k < 26; k++) {
                            char c = array[j];
                            array[j] = (char)('a' + k);
                            String s = new String(array);
                            if (!set.contains(s) && list.contains(s)) {
                                set.add(s);
                                queue.offer(s);
                            }
                            array[j] = c;
                        }
                    }
                }
            }
        }
        return 0;
    }
}