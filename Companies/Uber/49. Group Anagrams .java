class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String temp = helper(s);
            map.putIfAbsent(temp, new ArrayList<String>());
            map.get(temp).add(s);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
    private String helper(String s) {
        char[] temp = s.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }
}