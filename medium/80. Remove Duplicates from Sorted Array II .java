// i和n两个指针，一开始齐头并进，同时指向一个位置，当当前的数值不必他前前一个数值大的时候，意味着出现了3个
// 或3个以上的相同值，此时不满足if条件，i停留在不满足的位置，等待下一个更大的数来替换，当出现下一个更大的
// 数字时再次满足if条件，将i所指向的位置替换为该数字，i指向下一个等待替换，此时if条件再次用以检测用来替换
// 的数字，以保证不出现两次以上的重复。

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 3) return nums.length;
        int end = 2;
        for (int start = 2; start < nums.length; start++){
            if (nums[start] != nums[end - 2]){
                nums[end++] = nums[start];
            }
        }
        return end;
    }
}