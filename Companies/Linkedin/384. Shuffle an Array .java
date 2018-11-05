public class Solution {

    private int[] nums;
    
    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] random = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int r = new Random().nextInt(i + 1);
            random[i] = random[r];
            random[r] = nums[i];
        }
        return random;
    }
}


class Solution {

    int[] nums;
    Random random;
    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] clone = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            int j = random.nextInt(i + 1);
            int temp = clone[i];
            clone[i] = clone[j];
            clone[j] = temp;
        }
        return clone;
    }
}