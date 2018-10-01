class Solution {
    int res = 0;
    public int strobogrammaticInRange(String low, String high) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');map.put('1', '1');map.put('8', '8');
        map.put('6', '9');map.put('9', '6');
        for (int len = low.length(); len <= high.length(); len++) {
            helper(low, high, 0, len - 1, new char[len], map);
        }
        return res;
    }
    private void helper(String low, String high, int left, int right, char[] array, Map<Character, Character> map) {
        if (left > right) {
            String temp = new String(array);
            if ((temp.length() == low.length() && temp.compareTo(low) < 0) 
                || (temp.length() == high.length() && temp.compareTo(high) > 0)) {
                return;
            }
            res++;
            return;
        }
        for (Map.Entry<Character, Character> entry : map.entrySet()) {
            array[left] = entry.getKey();
            array[right] = entry.getValue();
            if (left == right && entry.getKey() != entry.getValue()) {
                continue;
            }
            if (array.length != 1 && array[0] == '0') {
                continue;
            }
            helper(low, high, left + 1, right - 1, array, map);
        }
    }
}