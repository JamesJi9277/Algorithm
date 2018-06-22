
public class Solution{
	public double myPow(double x, int n){
		if(n == 0)
			return 1.0;
		double half = myPow(x, n/2);
        if (n % 2 == 0) {
            // (-2 % 2 == 0) (-2 % 3 == -2)
            return half * half;
        } else if (n > 0) {
            return half * half * x;
        } else {
            return half * half / x;
        }
	}
}


class Solution {
    public double myPow(double x, int n) {
        if (x == 0) {
            return (double)0;
        }
        if (n == 0) {
            return (double)1.0;
        }
        if (n == 1) {
            return x;
        }
        if (n == -1) {
            return 1 / x;
        }
        double half = myPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else if (n > 0) {
            return x * half * half;
        } else {
            return half * half / x;// 这里的除以x对于负数次幂来说相当于是乘以了这个x
        }
    }
}