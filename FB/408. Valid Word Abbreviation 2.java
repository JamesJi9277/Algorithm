class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if (word == null || abbr == null) {
            return false;
        }
        int index1 = 0;
        int index2 = 0;
        while (index1 < word.length() && index2 < abbr.length()) {
            if (word.charAt(index1) != abbr.charAt(index2)) {
                if (!Character.isDigit(abbr.charAt(index2))) {
                    return false;
                }
                int i = index2 + 1;
                int temp = abbr.charAt(index2) - '0';
                if (temp == 0) {
                    return false;
                }
                while (i < abbr.length() && Character.isDigit(abbr.charAt(i))) {
                    temp = temp * 10 + (abbr.charAt(i) - '0');
                    i++;
                }
                index2 = i;
                for (int j = 0; j < temp; j++) {
                    if (index1 < word.length()) {
                        index1++;
                    } else {
                        return false;
                    }
                }
            } else {
                index1++;
                index2++;
            }
        }
        return index1 == word.length() && index2 == abbr.length();
    }
}