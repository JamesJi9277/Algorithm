class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //最多有两个元素大于1/3，所以要设置两个变量来记录
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int count1 = 0;
        int count2 = 0;
        int num1 = nums[0];
        int num2 = nums[0];
        for (int i : nums) {
            if (i == num1) {
                count1++;
            } else if (i == num2) {
                count2++;
            } else if (count1 == 0) {
                num1 = i;
                count1 = 1;
            } else if (count2 == 0) {
                num2 = i;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i : nums) {
            if (i == num1) {
                count1++;
            } else if (i == num2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            res.add(num1);
        }
        if (count2 > nums.length / 3) {
            res.add(num2);
        }
        return res;
    }
}


public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        for(int item : nums) {
            if(map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            }
            else {
                map.put(item, 1);
            }
        }
        for(int item : nums) {
            if(map.get(item) > nums.length / 3) {
                if(!set.contains(item)) {
                    res.add(item);
                    set.add(item);
                }
            }
        }
        return res;
    }
}