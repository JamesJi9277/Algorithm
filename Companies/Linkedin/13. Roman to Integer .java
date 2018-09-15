class Solution {
    public int romanToInt(String s) {
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);map.put("V", 5);map.put("X", 10 );map.put("L", 50);map.put("C", 100);map.put("D", 500 );map.put("M", 1000);
        int[] res = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            res[i] = map.get(s.charAt(i) + "");
        }
        int sum = 0;
        for (int i = 0; i < res.length - 1; i++) {
            if (res[i] < res[i + 1]) {
                sum -= res[i];
            } else {
                sum += res[i];
            }
        }
        sum += res[res.length - 1];
        return sum;
    }
}