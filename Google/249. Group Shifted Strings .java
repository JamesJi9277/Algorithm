class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            StringBuffer sb = new StringBuffer();
            for (int i = 1; i < s.length(); i++) {
                int diff = s.charAt(i) - s.charAt(i - 1);
                diff = diff >= 0 ? diff : 26 + diff;
                sb.append(diff + "");
            }
            String key = sb.toString();
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}