class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] count = new int[26];
        licensePlate = licensePlate.toLowerCase();
        for (char c : licensePlate.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                count[c - 'a']++;
            }
        }
        String res = "";
        for (String word : words) {
            if (match(count, word)) {
                if (res.equals("")) {
                    res = word;
                } else if (res.length() > word.length()) {
                    res = word;
                }
            }
        }
        return res;
    }
    private boolean match(int[] count, String word) {
        int[] count1 = count.clone();
        for (char c : word.toLowerCase().toCharArray()) {
            if (!(c >= 'a' && c <= 'z')) {
                return false;
            }
            count1[c - 'a']--;
        }
        for (int i : count1) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }
}