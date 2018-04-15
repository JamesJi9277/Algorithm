class Solution {
    public String multiply(String nums1, String nums2) {
        if (nums1 == null || nums1.length() == 0 || nums2 == null || nums2.length() == 0) {
            return "";
        }
        long i = Long.parseLong(nums1);
        long j = Long.parseLong(nums2);
        return String.valueOf(i * j);
    }
}

class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null) {
            return (num1 == null) ? num2 : num1;
        }
        int length1 = num1.length();
        int length2 = num2.length();
        int[] res = new int[length1 + length2];
        for (int i = length1 - 1; i >= 0; i--) {
            for (int j = length2 - 1; j >= 0; j--) {
                int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                res[i + j] = res[i + j] + (res[i + j + 1] + temp) / 10;
                res[i + j + 1] = (res[i + j + 1] + temp) % 10;
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i : res) {
            if(sb.length() > 0 || i > 0) {
                sb.append(i);
            }
        }
        return (sb.length() == 0) ? "0" : sb.toString();
    }
}