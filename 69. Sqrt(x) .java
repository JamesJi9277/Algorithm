class Solution {
    public int mySqrt(int x) {
        long start = 1;
		long end = x;
		while(start + 1 < end) {
			long mid = start + ((end - start)>>1);
			if(mid * mid == x) {
				return (int)mid;
			}
			else if (mid * mid < x) {
				start = mid;
			}
			else{
				end = mid;
			}
		}
		//因为Java里面是四舍五入，所以说应该先来比较end
		if(end * end == x) {
			return (int)end;
		}
		return (int)start;
    }
}