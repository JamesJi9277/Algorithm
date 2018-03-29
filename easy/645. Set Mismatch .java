时间On空间On
class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        HashSet<Integer> set = new HashSet<Integer>();
        int sum = 0;
        int n = nums.length;
        for (int i : nums) {
            sum += i;
            if (!set.add(i)) {
                res[0] = i;
            }
        }
        int diff = sum - (n * (n + 1) / 2);
        res[1] = res[0] - diff;
        return res;
    }
}
时间On空间O1
还是回归到最初的想法，当看见数组这种顺序性很强的题目的时候
可以考虑采用swap来将index归位
class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - 1 != i && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res[0] = nums[i];
                res[1] = i + 1;
                break;
            }
        }
        return res;
    }
}