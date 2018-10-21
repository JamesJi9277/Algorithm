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
        int i = -1;
        int j = -1;
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < words.length; k++) {
            if (words[k].equals(word1)) {
                i = k;
            } else if (words[k].equals(word2)) {
                j = k;
            }
            if (i != -1 && j != -1) {
                min = Math.min(min, Math.abs(j - i));
            }
        }
        return min;
    }
}