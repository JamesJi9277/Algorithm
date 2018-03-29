// more like a math problem
// https://leetcode.com/problems/poor-pigs/discuss/94328/Math-problem-Java-AC-code-with-brief-explanations-11092016
class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int res = 0;
        int testCase = minutesToTest / minutesToDie + 1;
        while (Math.pow(testCase, res) < buckets) {
            res++;
        }
        return res;
    }
}