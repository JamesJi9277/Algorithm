class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (words == null || words.length == 0) {
            return res;
        }
        // string-index
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        // blank
        if (map.containsKey("")) {
            int blankIdx = map.get("");
            for (int i = 0; i < words.length; i++) {
                if (isPalin(words[i])) {
                    if (i != blankIdx) {
                        res.add(Arrays.asList(blankIdx, i));
                        res.add(Arrays.asList(i, blankIdx));
                    }
                }
            }
        }
        // reverse pair
        for (int i = 0; i < words.length; i++) {
            String reversed = reverse(words[i]);
            if (map.containsKey(reversed)) {
                if (map.get(reversed) != i) {
                    res.add(Arrays.asList(i, map.get(reversed)));
                }
            }
        }
        // s1 [0, index] is palin and reverse(s2) is s1[index + 1], s2 + s1
        // reverse(s1) == s2[index + 1], and s2[0, index] is palin, s1 + s2
        for (int i = 0; i < words.length; i++) {
            String cur = words[i];
            for (int cut = 1; cut < cur.length(); cut++) {
                String temp1 = cur.substring(0, cut);
                String temp2 = cur.substring(cut);
                String reversed1 = reverse(temp2);
                String reversed2 = reverse(temp1);
                if (isPalin(temp1) && map.containsKey(reversed1)) {
                    res.add(Arrays.asList(map.get(reversed1), i));
                }
                if (isPalin(temp2) && map.containsKey(reversed2)) {
                    res.add(Arrays.asList(i, map.get(reversed2)));
                }
            }
        }
        return res;
    }
    private String reverse(String s) {
        return new StringBuffer(s).reverse().toString();
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
//
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (words == null || words.length == 0) {
            return res;
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    continue;
                }
                if (isPalin(words[i] + words[j])) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }
            }
        }
        return res;
    }
    private boolean isPalin(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
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

