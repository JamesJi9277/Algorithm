class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == (-2147483648) && divisor == (-1)) {
            return 2147483647;
        }
        else{
        	return (dividend / divisor);
        }
    }
}

class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if(dividend == 0 || divisor == 1) {
            return dividend;
        }
        if(dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long res = 0L;
        long num1 = Math.abs((long)dividend);
        long num2 = Math.abs((long)divisor);
        boolean isNeg = ((dividend < 0) ^ (divisor < 0)) == false ? false: true;
        while(num1 >= num2) {
            int count = 0;
            while(num1 >= (num2 << count)) {
                count++;
            }
            count--;
            long temp = (num2 << count);
            num1 %= temp;
            res += (1 << count);
        }
        return isNeg? (-1)*(int)res : (int) res;
    }
}