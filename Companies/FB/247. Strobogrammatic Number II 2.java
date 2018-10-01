class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        char[] list = new char[n];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1); map.put(6, 9); map.put(9, 6); map.put(8, 8);map.put(0, 0);
        helper(res, map, list, 0, n - 1);
        return res;
    }
    private void helper(List<String> res, Map<Integer, Integer> map, char[] list, int left, int right) {
        if (left > right) {
            res.add(new String(list));
            return;
        }
        if (left == right) {
            list[left] = '0';
            res.add(new String(list));
            list[left] = '1';
            res.add(new String(list));
            list[left] = '8';
            res.add(new String(list));
            return;
        }
        for (int i = 0; i < 10; i++) {
            if ((left == 0 && i == 0) || !map.containsKey(i)) {
                continue;
            }
            list[left] = (char)('0' + i);
            list[right] = (char)('0' + map.get(i));
            helper(res, map, list, left + 1, right - 1);
        }
    }
}