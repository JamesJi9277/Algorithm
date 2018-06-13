class Solution {
    public int numRabbits(int[] answers) {
        if(answers == null || answers.length == 0) return 0;
        int[] count = new int[1001];
        int ret = 0, max = 0;
        for(int a : answers) {
            max = Math.max(a, max);
            count[a] ++;
        }
        for(int i = 0; i <= max; i++){
            if(count[i] != 0)
                ret += (i + 1) * ((count[i] - 1)/(i + 1) + 1);
        }
        return ret;
    }
}