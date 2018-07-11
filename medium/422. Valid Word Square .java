class Solution {
    public boolean validWordSquare(List<String> words) {
        if (words == null || words.size() == 0) {
            return false;
        }
        int k = 0;
        for (String s : words) {
            String temp = readCol(words, k);
            if (!temp.equals(s)) {
                return false;
            }
            k++;
        }
        return true;
    }
    private String readCol(List<String> words, int k) {
        StringBuffer sb = new StringBuffer();
        for (String s : words) {
            if (k >= s.length()) {
                continue;
            }
            sb.append(s.charAt(k));
        }
        return sb.toString();
    }
}