class Solution {
    public int reverse(int x) {
        // treat it as String then do it as string manipulation
        // 考虑数字的范围问题
        String str = String.valueOf(x);
        boolean isNeg = false;
        if(str.charAt(0) == '-') {
            isNeg = true;
        }
        long weight = (long)1;
        long sum = (long)0;
        for(int i = (isNeg) ?1:0 ; i < str.length(); i++) {
            sum += (str.charAt(i) - '0') * weight;
            weight *= 10;
        }
        sum = (isNeg)? -sum : sum;
        if(sum > Integer.MAX_VALUE || sum <= Integer.MIN_VALUE) {
            return 0;
        }
        return (int) sum;
    }
}