class Solution {
    public String addBinary(String a, String b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        int carry = 0;
        int index1 = a.length() - 1;
        int index2 = b.length() - 1;
        StringBuffer sb = new StringBuffer();
        while (index1 >= 0 && index2 >= 0) {
            int sum = ((a.charAt(index1) - '0') + (b.charAt(index2) - '0') + carry) % 2;
            carry = ((a.charAt(index1) - '0') + (b.charAt(index2) - '0') + carry) / 2;
            sb.insert(0, sum);
            index1--;
            index2--;
        }
        while (index1 >= 0) {
            int sum = ((a.charAt(index1) - '0') + carry) % 2;
            carry = ((a.charAt(index1) - '0') + carry) / 2;
            sb.insert(0, sum);
            index1--;
        }
        while (index2 >= 0) {
            int sum = ((b.charAt(index2) - '0') + carry) % 2;
            carry = ((b.charAt(index2) - '0') + carry) / 2;
            sb.insert(0, sum);
            index2--;
        }
        if (carry == 1) {
            sb.insert(0, "1");
        }
        return sb.toString();
    }
}