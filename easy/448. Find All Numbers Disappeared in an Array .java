// 这题常规做法很容易想到
// 用Map来存 时间O1 空间On
// 或者先排序再比较 时间Onlogn 空间O1
// 第三种时间为On空间为O1，有点类似swap的思想
// 以后看见顺序性很强的数组题可以往swap上面靠
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // while表示两边都不相等，所以就需要来置换直到至少有一边满足条件
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                // 这里用temp很重要，因为如果用nums[i]来表示的话接下来这个值都会发生变化
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }
}