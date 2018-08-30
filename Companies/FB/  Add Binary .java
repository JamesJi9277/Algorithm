class Solution {
    public String addBinary(String a, String b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        int index1 = a.length() - 1;
        int index2 = b.length() - 1;
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        while (index1 >= 0 && index2 >= 0) {
            char c1 = a.charAt(index1);
            char c2 = b.charAt(index2);
            int sum = (c1 - '0') + (c2 - '0');
            sb.append((sum + carry) % 2 + "");
            carry = (sum + carry) / 2;
            index1--;
            index2--;
        }
        while (index1 >= 0) {
            char c1 = a.charAt(index1);
            int sum = (c1 - '0');
            sb.append((sum + carry) % 2 + "");
            carry = (sum + carry) / 2;
            index1--;
        }
        while (index2 >= 0) {
            char c2 = b.charAt(index2);
            int sum = (c2 - '0');
            sb.append((sum + carry) % 2 + "");
            carry = (sum + carry) / 2;
            index2--;
        }
        if (carry == 1) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}