class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<Integer>());
            }
            List<Integer> list = map.get(words[i]);
            list.add(i);
            map.put(words[i], list);
        }
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        for (int i : list1) {
            for (int j : list2) {
                res = Math.min(res, Math.abs(i - j));
            }
        }
        return res;
    }
}

class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
            } else if (words[i].equals(word2)) {
                index2 = i;
            } 
            if (index1 != -1 && index2 != -1) {
                res = Math.min(res, Math.abs(index2 - index1));
            }
        }
        return res;
    }
}