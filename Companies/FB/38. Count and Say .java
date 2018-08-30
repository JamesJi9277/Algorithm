class Solution {
    public String countAndSay(int n) {
        if (n == 0) {
            return "";
        }
        String res = "1";
        while (--n > 0) {
            StringBuffer sb = new StringBuffer();
            int count = 1;
            for (int i = 0; i < res.length(); i++) {
                while (i < res.length() - 1 && res.charAt(i) == res.charAt(i + 1)) {
                    count++;
                    i++;
                }
                sb.append(count);
                sb.append(res.charAt(i));
                count = 1;
            }
            res = sb.toString();
        }
        return res;
    }
}

// second write
class Solution {
    public String countAndSay(int n) {
        if (n == 0) {
            return "";
        }
        String res = "1";
        while (--n > 0) {
            StringBuffer sb = new StringBuffer();
            int count = 1;
            for (int i = 0; i < res.length(); i++) {
                while (i + 1 < res.length() && res.charAt(i) == res.charAt(i + 1)) {
                    i++;
                    count++;
                }
                sb.append(count);
                sb.append(res.charAt(i));
                count = 1;
            }
            res = sb.toString();
        }
        return res;
    }
}