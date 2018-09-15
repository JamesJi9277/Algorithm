On
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        if (word1.equals(word2)) {
            return 0;
        }
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.putIfAbsent(words[i], new ArrayList<Integer>());
            map.get(words[i]).add(i);
        }
        int min = Integer.MAX_VALUE;
        int index1 = 0;
        int index2 = 0;
        while (index1 < map.get(word1).size() && index2 < map.get(word2).size()) {
            min = Math.min(min, Math.abs(map.get(word1).get(index1) - map.get(word2).get(index2)));
            if (map.get(word1).get(index1) - map.get(word2).get(index2) > 0) {
                index2++;
            } else if (map.get(word1).get(index1) - map.get(word2).get(index2) < 0) {
                index1++;
            }
        }
        return min;
    }
}
On
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        if (word1.equals(word2)) {
            return 0;
        }
        int index1 = -1;
        int index2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
            } else if (words[i].equals(word2)) {
                index2 = i;
            }
            if (index1 != -1 && index2 != -1) {
                min = Math.min(min, Math.abs(index1 - index2));
            }
        }
        return min;
    }
}