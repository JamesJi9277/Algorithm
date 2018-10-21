class WordDistance {

    List<String> list;
    Map<String, Integer> map;
    public WordDistance(String[] words) {
        if (words == null || words.length == 0) {
            return;
        }
        list = new ArrayList<>();
        map = new HashMap<>();
        for (String s : words) {
            list.add(s);
        }
    }
    
    public int shortest(String word1, String word2) {
        if (word1.equals(word2)) {
            return 0;
        }
        String path1 = word1 + "->" + word2;
        String path2 = word2 + "->" + word1;
        if (map.containsKey(path1)) {
            return map.get(path1);
        }
        if (map.containsKey(path2)) {
            return map.get(path2);
        }
        int index1 = -1;
        int index2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word1)) {
                index1 = i;
            }
            if (list.get(i).equals(word2)) {
                index2 = i;
            }
            if (index1 != -1 && index2 != -1) {
                min = Math.min(min, Math.abs(index1 - index2));
            }
        }
        map.put(path1, min);
        map.put(path2, min);
        return min;
    }
}
class WordDistance {

    Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.putIfAbsent(words[i], new ArrayList<Integer>());
            map.get(words[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int max = Integer.MAX_VALUE;
        int index1 = 0;
        int index2 = 0;
        while (index1 < list1.size() && index2 < list2.size()) {
            int val1 = list1.get(index1);
            int val2 = list2.get(index2);
            if (Math.abs(val1 - val2) < max) {
                max = Math.abs(val1 - val2);
            }
            if (val1 < val2) {
                index1++;
            } else {
                index2++;
            }
        }
        return max;
    }
}