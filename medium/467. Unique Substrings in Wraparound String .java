class Solution {
    public int findSubstringInWraproundString(String p) {
        if (p == null || p.length() == 0) {
            return 0;
        }
        int[] res = new int[26];
        int curMax = 0;
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || (p.charAt(i - 1) - p.charAt(i) == 25))) {
                curMax++;
            } else {
                curMax = 1;
            }
            int index = p.charAt(i) - 'a';
            res[index] = Math.max(res[index], curMax);
        }
        int sum = 0;
        for (int i : res) {
            sum += i;
        }
        return sum;
    }
}

class Solution {
    public int findSubstringInWraproundString(String p) {
        if (p == null || p.length() == 0) {
            return 0;
        }
        HashSet<String> set = new HashSet<>();
        int right = 0;
        while (right < p.length()) {
            int left = 0;
            while (left <= right) {
                String temp = p.substring(left, right + 1);
                if (isValid(temp) && !set.contains(temp)) {
                    set.add(temp);
                }
                left++;
            }
            right++;
        }
        return set.size();
    }
    private boolean isValid(String s) {
        int i = 0;
        while (i + 1 < s.length()) {
            if (((s.charAt(i) - 95) % 26 - s.charAt(i + 1) + 96) != 0) {
                return false;
            }
            i++;
        }
        return true;
    }
}