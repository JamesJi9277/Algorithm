class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return res;
        }
        StringBuffer sb = new StringBuffer();
        helper(res, num, sb, 0, 0, 0, target);
        return res;
    }
    private void helper(List<String> res, String num, StringBuffer sb, int index, long prev, long curSum, long target) {
        if (index == num.length()) {
            if (curSum == target) {
                res.add(new String(sb));
            }
            return;
        }
        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') {
                break;
            }
            int len = sb.length();
            long temp = Long.valueOf(num.substring(index, i + 1));
            if (index == 0) {
                helper(res, num, sb.append(temp), i + 1, temp, temp, target);
                sb.setLength(len);
            } else {
                sb.append("+");
                sb.append(temp);
                helper(res, num, sb, i + 1, temp, curSum + temp, target);
                sb.setLength(len);
                
                sb.append("-");
                sb.append(temp);
                helper(res, num, sb, i + 1, -temp, curSum - temp, target);
                sb.setLength(len);
               
                sb.append("*");
                sb.append(temp);
                helper(res, num, sb, i + 1, temp * prev, curSum - prev + temp * prev, target);
                sb.setLength(len);
            }
        }
    }
}