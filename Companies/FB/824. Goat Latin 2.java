class Solution {
    public String toGoatLatin(String S) {
        // start with vowel, append ma to end
        // if not, move first to end, and append ma
        // add a to end according to index
        if (S == null || S.length() == 0) {
            return S;
        }
        StringBuffer sb = new StringBuffer();
        String[] strs = S.split(" ");
        int count = 1;
        for (String s : strs) {
            char c = s.charAt(0);
            if (isVowel(c)) {
                StringBuffer sb1 = new StringBuffer(s);
                sb1.append("ma");
                int temp = count;
                for (int i = 0; i < temp; i++) {
                    sb1.append("a");
                }
                count++;
                sb1.append(" ");
                sb.append(sb1.toString());
            } else if (!isVowel(c)) {
                StringBuffer sb2 = new StringBuffer(s);
                sb2.append(c);
                sb2.deleteCharAt(0);
                sb2.append("ma");
                int temp = count;
                for (int i = 0; i < temp; i++) {
                    sb2.append("a");
                }
                count++;
                sb2.append(" ");
                sb.append(sb2.toString());
            }
        }
        return sb.toString().trim();
    }
    private boolean isVowel(char c) {
        return c == 'a'|| c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'I' || c == 'O' || c == 'A' || c == 'E' || c == 'U';
    }
}