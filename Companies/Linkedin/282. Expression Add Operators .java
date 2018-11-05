class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return res;
        }
        StringBuffer sb = new StringBuffer();
        helper(res, sb, num, target, 0, 0, 0);
        return res;
    }
    private void helper(List<String> res, StringBuffer sb, String num, int target, int index, long curSum, long pre) {
        if (index == num.length()) {
            if (curSum == target) {
                res.add(new String(sb));
            }
            return;
        }
        int len = sb.length();
        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') {
                break;
            }
            long temp = Long.valueOf(num.substring(index, i + 1));
            if (index == 0) {
                sb.append(temp);
                helper(res, sb, num, target, i + 1, curSum + temp, temp);
                sb.setLength(len);
            } else {
                sb.append("+");
                sb.append(temp);
                helper(res, sb, num, target, i + 1, curSum + temp, temp);
                sb.setLength(len);
                
                sb.append("-");
                sb.append(temp);
                helper(res, sb, num, target, i + 1, curSum - temp, -temp);
                sb.setLength(len);
                
                sb.append("*");
                sb.append(temp);
                helper(res, sb, num, target, i + 1, curSum - pre + pre * temp, pre * temp);
                sb.setLength(len);
            }
        }
    }
}