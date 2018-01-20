class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        Arrays.sort(strs);
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            String pivot = toStandard(s);
            if (map.containsKey(pivot)) {
                List<String> temp = map.get(pivot);
                temp.add(s);
                map.put(pivot, temp);
            } else {
                List<String> temp = new ArrayList<String>();
                temp.add(s);
                map.put(pivot, temp);
            }
        }
        for (String s : map.keySet()) {
            result.add(map.get(s));
        }
        return result;
    }
    private String toStandard(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return array.toString();
    }
}