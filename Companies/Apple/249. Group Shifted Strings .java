class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String diff = helper(s);
            map.putIfAbsent(diff, new ArrayList<>());
            map.get(diff).add(s);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
    private String helper(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length() - 1; i++) {
            int diff = s.charAt(i + 1) - s.charAt(i);
            diff = diff > 0 ? diff : diff + 26;
            sb.append(diff);
        }
        return sb.toString();
    }
}