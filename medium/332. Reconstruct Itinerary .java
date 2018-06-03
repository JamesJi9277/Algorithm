class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<String>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        if (tickets == null || tickets.length == 0 || tickets[0].length == 0) {
            return res;
        }
        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])) {
                map.put(ticket[0], new ArrayList<String>());
            }
            map.get(ticket[0]).add(ticket[1]);
        }
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        helper(map, res, "JFK");
        res.add("JFK");
        Collections.reverse(res);
        return res;
    }
    private void helper(Map<String, List<String>> map, List<String> res, String s) {
        if (!map.containsKey(s) || map.get(s).size() == 0) {
            return;
        }
        while (map.get(s).size() != 0) {
            String s1 = map.get(s).get(0);
            map.get(s).remove(0);
            helper(map, res, s1);
            res.add(s1);
        }
    }
}