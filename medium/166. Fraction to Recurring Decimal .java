class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // 出现循环的可能性代表出现了相同的被除数
        if (numerator == 0) {
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        sb.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        sb.append(num / den);
        num %= den;
        if (num == 0) {
            return sb.toString();
        }
        
        // fraction part
        sb.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, sb.length());
        while (num != 0) {
            num *= 10;
            sb.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                sb.insert(index, "(");
                sb.append(")");
                break;
            } else {
                map.put(num, sb.length());
            }
        }
        return sb.toString();
    }
}