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



class Solution {
    public boolean validWordSquare(List<String> words) {
        if (words == null || words.size() == 0) {
            return false;
        }
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                try {
                    if (words.get(i).charAt(j) != words.get(j).charAt(i)) {
                        return false;
                    }
                } catch (IndexOutOfBoundsException e) {
                    return false;
                }
            }
        }
        return true;
    }
}