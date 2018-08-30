class Solution {
    public String nextClosestTime(String time) {
        int[] nums = new int[4];
        nums[0] = time.charAt(0) - '0';
        nums[1] = time.charAt(1) - '0';
        nums[2] = time.charAt(3) - '0';
        nums[3] = time.charAt(4) - '0';
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int[] max = new int[]{2, 9, 5, 9};
        if (nums[0] == 2) {
            max[1] = 3;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != sorted[3] && nums[i] < max[i]) {
                for (int j = 0; j < sorted.length; j++) {
                    if (sorted[j] > nums[i] && sorted[j] <= max[i]) {
                        nums[i] = sorted[j];
                        return toTime(nums);
                    }
                }
            }
            nums[i] = sorted[0];
        }
        return toTime(nums);
    }
    private String toTime(int[] nums) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            sb.append(nums[i] + "");
            if (i == 1) {
                sb.append(":");
            }
        }
        return sb.toString();
    }
}