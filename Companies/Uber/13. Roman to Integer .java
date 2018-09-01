class Solution {
    public int romanToInt(String s) {
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);map.put('V', 5);map.put('X', 10);map.put('L', 50);
        map.put('C', 100);map.put('D', 500); map.put('M', 1000);
        int res = 0;
        int[] array = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            array[i] = map.get(s.charAt(i));
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                res -= array[i];
            } else {
                res += array[i];
            }
        }
        res += array[array.length - 1];
        return res;
    }
}