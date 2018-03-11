class Solution {
    public String addBinary(String a, String b) {
        int a1 = Integer.parseInt(a, 2);
        int b1 = Integer.parseInt(b, 2);
        return Integer.toString(a1 + b1, 2);
    }
}

public class Solution {
    public String addBinary(String a, String b) {
        if(a.length() == 0 || b.length() ==0 || a == null || b == null)
            return a.length()!=0? a:b;
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        int carry = 0;
        StringBuffer sb = new StringBuffer();
        while(aIndex >= 0 || bIndex >= 0) {
            int aDigit = (aIndex >= 0) ? a.charAt(aIndex) - '0' : 0;
            int bDigit = (bIndex >= 0) ? b.charAt(bIndex)- '0' : 0;
            int digit = (aDigit + bDigit + carry) % 2;
            carry = (aDigit + bDigit + carry) / 2;
            sb.append(digit + "");
            aIndex--;
            bIndex--;
        }
        if(carry == 1) {
            sb.append("1");
        }
        return sb.reverse().toString();
    }
}
