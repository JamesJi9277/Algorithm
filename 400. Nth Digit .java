class Solution {
    public int findNthDigit(int n) {
        int start = 1;
        int len = 1;
        long base = 9;
        while( n > len * base ){    //判断n落在的区间
            n = n - len * (int)base;     
            len++;              //len 用来记录target 数的长度
            start *= 10;        //循环的时候不用，等会用来重组target 数
            base *= 10;
        }
        int target = start + (n - 1)/len;   //减1是因为start 自己算一个数，要把start 从计算中抠掉
        int reminder = (n - 1)%len;         //在target 中的位置
        return Character.getNumericValue( Integer.toString(target).charAt(reminder) );
    }
}