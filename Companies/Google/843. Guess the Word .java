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
            String guess = wordlist[new Random().nextInt(wordlist.length)];
            int x = master.guess(guess);
            List<String> res = new ArrayList<>();
            for (String w : wordlist) {
                if (match(guess, w) == x) {
                    res.add(w);
                }
            }
            wordlist = res.toArray(new String[res.size()]);
        }
    }
    private int match(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}

class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        for (int i = 0; i < 10; i++) {
            //generate test word
            int best = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < wordlist.length; j++) {
                int value = findPeak(wordlist, wordlist[j]);
                if (min > value) {
                    min = value;
                    best = j;
                }
            }
            
            int feedback = master.guess(wordlist[best]);
            //only keep words that share the same match count with the test word
            List<String> list = new LinkedList<String>();
            for (String item : wordlist) {
                if (same(item, wordlist[best]) == feedback) {
                    list.add(item);
                }
            }
            wordlist = list.toArray(new String[0]);
        }    
    }
    private int findPeak(String[] wordlist, String str) {
        int max = 0;
        int[] count = new int[7];
        for (int i = 0; i < wordlist.length; i++) {
            count[same(wordlist[i], str)]++;
        }
        for (int i = 0; i <= 6; i++) {
            max = Math.max(max, count[i]);
        }
        return max;
    }
    private int same(String a, String b) {
        int res = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                res++;
            }
        }
        return res;
    }
}