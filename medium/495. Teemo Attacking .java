class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0 || duration == 0) {
            return 0;
        }

        int poisonAttackStarted = timeSeries[0];
        int poisonTotalDuration = 0;

        for (int i = 1; i < timeSeries.length; i++) {
        //case1: when poison duration has already finished for previous attack, we will add duration in total time
        if (timeSeries[i] > poisonAttackStarted + duration - 1) {
             poisonTotalDuration += duration;
        } else {  
            //case2: when poison duration has not already finished for previous attack, we will add the elapsed time in the duration
            poisonTotalDuration += (timeSeries[i] - poisonAttackStarted);
        }
        // resetting poison attack started pointer
            poisonAttackStarted = timeSeries[i];
        }

        //we always needs to add duration for the last attack
        return poisonTotalDuration + duration;
    }
}