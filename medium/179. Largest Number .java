class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        List<String> array = new ArrayList<String>();
        for (int i : nums) {
            array.add(i + "");
        }
        Collections.sort(array, new Comp());        
        StringBuffer sb = new StringBuffer();
        for (String s : array) {
            sb.append(s);
        }
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }

    private class Comp implements Comparator<String> {
        public int compare(String s1, String s2) {
            if (s1.equals(s2)) {
                return 0;
            }
            if (s1.length() != s2.length()) {
                return compare(s1 + s2, s2 + s1);
            }
            for (int i = 0; i < s1.length(); i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                if (c1 == c2) {
                    continue;
                } else if (c1 > c2) {
                    //按照降序来排列
                    return -1;
                } else {
                    return 1;
                }
            }
            return 0;
        }
    }
}