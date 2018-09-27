class Solution {
    public String getHint(String secret, String guess) {
        int[] count = new int[10];
        int a = 0;
        int b = 0;
        for (int i = 0; i < secret.length(); i++) {
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if (c1 == c2) {
                a++;
                continue;
            }
            if (count[c1 - '0'] < 0) {
                b++;
            }
            if (count[c2 - '0'] > 0) {
                b++;
            }
            count[c1 - '0']++;
            count[c2 - '0']--;
        }
        return a + "A" + b + "B";
    }
}