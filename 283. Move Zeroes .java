利用一个nonZero的表示来不断进行swap，
之所以利用到nonZero是因为数组中一开始就没有0，考虑到这种特殊情况


// 总体来说是需要两个指针，一个扫数组，一个根据当前顺序来记录0的信息
class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[zero];
                nums[zero] = temp;
                zero++;
            }
        }
    }
}
时间上要优化一下，不需要每次都swap而是类似remove duplicate的做法，
进行0个数的统计然后对数组末未开始的元素重新赋值
public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return;
        }
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] == 0) {
        		count++;
        	}
        	else {
        		nums[i - count] = nums[i]; 
        	}
        }
        for(int i = 0; i < count; i++) {
        	nums[nums.length - 1 - i] = 0;
        }
    }
}