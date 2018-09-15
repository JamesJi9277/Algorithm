class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.putIfAbsent(words[i], new ArrayList<Integer>());
            map.get(words[i]).add(i);
        }
        int min = Integer.MAX_VALUE;
        if (word1.equals(word2)) {
            List<Integer> list = map.get(word1);
            Collections.sort(list);
            for (int i = 0; i < list.size() - 1; i++) {
                min = Math.min(min, list.get(i + 1) - list.get(i));
            }
        } else {
            List<Integer> list1 = map.get(word1);
            List<Integer> list2 = map.get(word2);
            int index1 = 0;
            int index2 = 0;
            while (index1 < list1.size() && index2 < list2.size()) {
                min = Math.min(min, Math.abs(list1.get(index1) - list2.get(index2)));
                if (list1.get(index1) < list2.get(index2)) {
                    index1++;
                } else if (list1.get(index1) > list2.get(index2)) {
                    index2++;
                }
            }
        }
        return min;
    }
}

class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        boolean same = word1.equals(word2);
        int index1 = -1;
        int index2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
            }
            if (words[i].equals(word2) && !same) {
                index2 = i;
            }
            if (index1 != -1 && index2 != -1) {
                min = Math.min(min, Math.abs(index1 - index2));
            }
            if (same && index1 != -1) {
                index2 = index1;
                index1 = -1;
            }
        }
        return min;
    }
}