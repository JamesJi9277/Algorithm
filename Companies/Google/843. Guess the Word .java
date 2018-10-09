class Solution {
    public void findSecretWord(String[] wordList, Master master) {
        for (String word : wordList) {
            if (master.guess(word) == word.length()) {
                return;
            }
        }
    }
}

class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        for (int i = 0; i < 10; i++) {
            String random = wordlist[new Random().nextInt(wordlist.length)];
            int count = master.guess(random);
            List<String> res = new ArrayList<>();
            for (String word : wordlist) {
                if (match(word, random) == count) {
                    res.add(word);
                }
            }
            String[] temp = new String[res.size()];
            for (int j = 0; j < temp.length; j++) {
                temp[j] = res.get(j);
            }
            wordlist = temp;
        }
    }
    private int match(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}

/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
// 找相似度最低的
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        for (int i = 0; i < 10; i++) {
            int best = -1;
            int min = Integer.MAX_VALUE;
            for (int k = 0; k < wordlist.length; k++) {
                int value = findPeak(wordlist, wordlist[k]);
                if (min > value) {
                    min = value;
                    best = k;
                }
            }
            
            int count = master.guess(wordlist[best]);
            List<String> res = new ArrayList<>();
            for (String word : wordlist) {
                if (match(word, wordlist[best]) == count) {
                    res.add(word);
                }
            }
            String[] temp = new String[res.size()];
            for (int j = 0; j < temp.length; j++) {
                temp[j] = res.get(j);
            }
            wordlist = temp;
        }
    }
    private int findPeak(String[] list, String s) {
        int max = 0;
        int[] count = new int[7];
        for (int i = 0; i < list.length; i++) {
            int temp = match(s, list[i]);
            count[temp]++;
            max = Math.max(max, count[temp]);
        }
        return max;
    }
    private int match(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}