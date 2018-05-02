// 因为并不保证每个数都会出现而只多出来一个数
// 所以说传统的方法比如求和什么是行不通的
// 利用linkedlist cycle的方法来做
class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}