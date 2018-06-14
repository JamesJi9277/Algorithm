class Solution {
    public boolean validWordSquare(List<String> words) {
        int ct = 0;
        for (String s : words) {
            String colRead = columnRead(words, ct);
            ct++;
            if (!colRead.equals(s)) {
                return false;
            }
        }
        return true;
    }
    private String columnRead(List<String> words, int index) {
        StringBuilder sb = new StringBuilder();
        for (String s : words) {
            if (index < s.length()) {
                sb.append(s.charAt(index));
            }
        }
        return sb.toString();
    }
}