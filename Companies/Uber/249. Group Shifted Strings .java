class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            StringBuffer sb = new StringBuffer();
            for (int i = 1; i < s.length(); i++) {
                int diff = s.charAt(i) - s.charAt(i - 1);
                diff = diff > 0 ? diff : diff + 26;
                sb.append(diff + "");
            }
            map.putIfAbsent(sb.toString(), new ArrayList<>());
            map.get(sb.toString()).add(s);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }
}