class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int length = 0;
        StringBuffer sb = new StringBuffer();
        for (String s : sentence) {
            s += " ";
            sb.append(s);
            length += s.length();
        }
        int start = 0;
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (sb.charAt(start % length) == ' ') {
                start++;
            } else {
                while (start > 1 && sb.charAt((start - 1) % length) != ' ') {
                    start--;
                }
            }
        }
        return start / length;
    }
}