// use map to count frequency
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        int num = words.length;
        int len = words[0].length();
        for (int i = 0; i < s.length() - num * len + 1; i++) {
            Map<String, Integer> temp = new HashMap<>();
            int j = 0;
            while (j < num) {
                String word = s.substring(i + j * len, i + (j + 1) * len);
                if (count.containsKey(word)) {
                    temp.put(word, temp.getOrDefault(word, 0) + 1);
                    if (temp.get(word) > count.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == num) {
                res.add(i);
            }
        }
        return res;
    }
}