public class Solution {
    public String countAndSay(int n) {
        if(n < 1) {
            return "";
        }
        String res = "1";
        while(--n > 0) {
            char[] nums = res.toCharArray();
            StringBuffer sb = new StringBuffer();
            int count = 1;
            for(int i = 0; i < nums.length; i++) {
                if(i != nums.length - 1 && nums[i] == nums[i + 1]) {
                    count++;
                    continue;
                }
                sb.append(count);
                sb.append(nums[i]);
                count = 1;
            }
            res = sb.toString();
        }
        return res;
    }
}