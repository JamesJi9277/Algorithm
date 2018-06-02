class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                String s1 = words[i];
                String s2 = words[j];
                if (noDup(s1, s2)) {
                    max = Math.max(s1.length() * s2.length(), max);
                }
            }
        }
        return max;
    }
    private boolean noDup(String s1, String s2) {
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < s1.length(); i++) {
            set.add(s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {
            if (set.contains(s2.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}

class Solution {
    public int maxProduct(String[] words) {
        int len = words.length, maxProd = 0;
        int[] nums = new int[len];
        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray()) {
                nums[i] = nums[i] | (1 << (ch -'a'));
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if ((nums[i] & nums[j]) == 0) {
                    maxProd = Math.max(maxProd, words[i].length() * words[j].length());
                }
            }
        }
        return maxProd;
    }
}