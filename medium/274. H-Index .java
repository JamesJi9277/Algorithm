public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) {
            return 0;
        }
        int res = 0;
        Arrays.sort(citations);
        int length = citations.length;
        for(int i = length - 1; i >= 0; i--) {
            int numPaper = length - i;
            int numCitation = citations[i];
            if(numCitation >= numPaper) {
                res = Math.max(res, numPaper);
            }
        }
        return res;
    }
}



public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) {
          return 0;
        }
        int length = citations.length;
        //因为我要构建后缀和的时候需要表达的是前多少多少个，所以数组需要多扩充一位
        int[] res = new int[length + 1];
        //下面是对数组的count处理，如果引用了三次的话，那么res[3]这个地方就++
        //如果引用的次数超过了长度的时候，那么就在数组最末尾++，这里数组的长度相当于是我有几本书至少被引用了几次
        for(int i = 0; i < length; i++) {
          if(citations[i] >= length) {
            res[length]++;
          }
          else {
            res[citations[i]]++;
          }
        }
        //根据上面我的定义，res[]表示的是我有几本书至少被引用了几次，但是我第一次的count仅仅表示确切的引用次数而没表示至少引用的次数
        //为了计算出至少引用的次数，我还需要进行一个求和，即使从后往前的累加过程，这样子就可以求出一个几个文献至少被引用了几次
        for(int i = length - 1; i >= 0; i--) {
          res[i] += res[i + 1];
        }
        //最后根据题目中的定义，N篇论文分别被引用了至少N次，他的H指数就是N
        //这里res[i]表示的是有几篇论文，然后下标i表示的是被引用的次数
        for(int i = length; i > 0; i--) {
          if(res[i] >= i) {
            return i;
          }
        }
        return 0;
    }
}
