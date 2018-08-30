class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        StringBuffer sb = new StringBuffer(s);
        Set<Character> set = new HashSet<>();
        set.add('a');set.add('e');set.add('i');set.add('o');set.add('u');
        set.add('A');set.add('E');set.add('I');set.add('O');set.add('U');
        int left = 0;
        int right = sb.length() - 1;
        while (left < right) {
            while (left < right && !set.contains(sb.charAt(left))) {
                left++;
            }
            while (left < right && !set.contains(sb.charAt(right))) {
                right--;
            }
            char c = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, c);
            left++;
            right--;
        }
        return sb.toString();
    }
}