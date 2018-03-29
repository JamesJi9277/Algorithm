class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null) {
            return res;
        }
        helper(s, res, 0);
        return res;
    }
    private void helper(String s, List<String> res, int index) {
        if (index == s.length()) {
            res.add(s);
            return;
        }
        if (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            helper(s, res, index + 1);
            return;
        }
        char[] array = s.toCharArray();
        
        array[index] = Character.toLowerCase(array[index]);
        helper(String.valueOf(array), res, index + 1);
        
        array[index] = Character.toUpperCase(array[index]);
        helper(String.valueOf(array), res, index + 1);
    }
}