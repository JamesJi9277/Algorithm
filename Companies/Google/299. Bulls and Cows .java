class Solution {
    public String getHint(String secret, String guess) {
        int[] count = new int[10];
        for (char c : secret.toCharArray()) {
            count[c - '0']++;
        }
        int total = 0;
        int hit = 0;
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == secret.charAt(i)) {
                hit++;
            }
            if (count[guess.charAt(i) - '0']-- > 0) {
                total++;
            }
        }
        return "" + hit + "A" + (total - hit) + "B";
    }
}

class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, List<Integer>> map = new HashMap<>();
        Map<Character, List<Integer>> map1 = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            map.putIfAbsent(secret.charAt(i), new ArrayList<Integer>());
            map.get(secret.charAt(i)).add(i);
        }
        for (int i = 0; i < guess.length(); i++) {
            map1.putIfAbsent(guess.charAt(i), new ArrayList<Integer>());
            map1.get(guess.charAt(i)).add(i);
        }
        int A = 0;
        int B = 0;
        for (int k = 0; k < guess.length(); k++) {
            char c = guess.charAt(k);
            if (!map.containsKey(c)) {
                continue;
            }
            List<Integer> temp = map.get(c);
            List<Integer> temp1 = map1.get(c);
            int match = 0;
            for (int i : temp1) {
                for (int j : temp) {
                    if (i == j) {
                        match++;
                    }
                }
            }
            A += match;
            B += (Math.min(temp.size(), temp1.size()) - match);
            map.remove(c);
        }
        return "" + A + "A" + B + "B";
    }
}