class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);map.put('V', 5);map.put('X', 10);map.put('L', 50);map.put('C', 100);map.put('D', 500 );map.put('M', 1000);
        int[] res = new int[s.length()];
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            res[i] = map.get(s.charAt(i));
        }
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