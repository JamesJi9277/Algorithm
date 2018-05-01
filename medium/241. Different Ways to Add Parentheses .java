class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        if (input == null || input.length() == 0) {
            return res;
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String s1 = input.substring(0, i);
                String s2 = input.substring(i + 1);
                List<Integer> nums1 = diffWaysToCompute(s1);
                List<Integer> nums2 = diffWaysToCompute(s2);
                for (int m : nums1) {
                    for (int n : nums2) {
                        switch (c) {
                            case '+': res.add(m + n);
                                break;
                            case '-': res.add(m - n);
                                break;
                            case '*': res.add(m * n);
                                break;
                        }
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.parseInt(input));
        }
        return res;
    }
}