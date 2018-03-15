// 这题常规做法很容易想到
// 用Map来存 时间O1 空间On
// 或者先排序再比较 时间Onlogn 空间O1
// 第三种时间为On空间为O1，有点类似swap的思想
// 以后看见顺序性很强的数组题可以往swap上面靠
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }
}