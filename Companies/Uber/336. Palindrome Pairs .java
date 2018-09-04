class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        // 1. self is palin + ""
        // 2. self + reverse existed
        // 3. first part is palin and reversed half existed
        // 4. second part is palin and reversed half existed

        for (String word : words) {
            if (isPalin(word)) {
                if (map.containsKey("") && map.get("") != map.get(word)) {
                    res.add(Arrays.asList(map.get(word), map.get("")));
                    res.add(Arrays.asList(map.get(""), map.get(word)));
                }
            }
            String reversed = new StringBuffer(word).reverse().toString();
            if (map.containsKey(reversed) && map.get(reversed) != map.get(word)) {
                res.add(Arrays.asList(map.get(word), map.get(reversed)));
            }
            
            for (int cut = 1; cut < word.length(); cut++) {
                String temp1 = word.substring(0, cut);
                String temp2 = word.substring(cut);
                String reversed1 = new StringBuffer(temp1).reverse().toString();
                String reversed2 = new StringBuffer(temp2).reverse().toString();
                if (isPalin(temp1) && map.containsKey(reversed2)) {
                    res.add(Arrays.asList(map.get(reversed2), map.get(word)));
                }
                if (isPalin(temp2) && map.containsKey(reversed1)) {
                    res.add(Arrays.asList(map.get(word), map.get(reversed1)));
                }
            }
        }
        return res;
    }
    private boolean isPalin(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}