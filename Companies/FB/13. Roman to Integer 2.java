class Solution {
    public int romanToInt(String s) {
        // Symbol       Value
        // I             1
        // V             5
        // X             10
        // L             50
        // C             100
        // D             500
        // M             1000
        int[] nums = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'I' :
                    nums[i] = 1;
                    break;
                case 'V' :
                    nums[i] = 5;
                    break;
                case 'X' :
                    nums[i] = 10;
                    break;
                case 'L' :
                    nums[i] = 50;
                    break;
                case 'C' :
                    nums[i] = 100;
                    break;
                case 'D' :
                    nums[i] = 500;
                    break;
                case 'M' :
                    nums[i] = 1000;
                    break;
            }
        }
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                sum -= nums[i];
            } else {
                sum += nums[i]; // contains III equals
            }
        }
        sum += nums[nums.length - 1];
        return sum;
    }
}