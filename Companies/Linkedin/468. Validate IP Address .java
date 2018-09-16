class Solution {
    public String validIPAddress(String IP) {
        // four groups, split by . leading zero in v4 is invalid, first digit can't be zero
        // eight groups, split by : , 4 digits or only zero, 
        if (IP == null || IP.length() == 0) {
            return "Neither";
        }
        if (validV4(IP)) {
            return "IPv4";
        } else if (validV6(IP)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }
    private boolean validV4(String s) {
        // minimum with length 7
        // 1.1.1.1
        if (s.length() < 7) {
            return false;
        }
        if (s.charAt(0) == '.' || s.charAt(s.length() - 1) == '.') {
            return false;
        }
        String[] strs = s.split("\\.");
        if (strs.length != 4) {
            return false;
        }
        for (String str : strs) {
            if (!valid4(str)) {
                return false;
            }
        }
        return true;
    }
    private boolean valid4(String s) {
        if (s.equals("") || s.length() > 3) {
            return false;
        }
        if (s.charAt(0) == '0' && s.length() > 1) {
            return false;
        }

        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        int i = Integer.parseInt(s);
        if (i < 0 || i > 255) {
            return false;
        }
        return true;
    }
    private boolean validV6(String s) {
        // minimum length
        // 1:1:1:1:1:1:1:1
        if (s.length() < 15) {
            return false;
        }
        if (s.charAt(0) == ':' || s.charAt(s.length() - 1) == ':') {
            return false;
        }
        String[] strs = s.split(":");
        if (strs.length != 8) {
            return false;
        }
        for (String str : strs) {
            if (!valid6(str)) {
                return false;
            }
        }
        return true;
    }
    private boolean valid6(String s) {
        if (s.length() == 0 || s.length() > 4) {
            return false;
        }
        s = s.toLowerCase();
        for (char c : s.toCharArray()) {
            if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f'))) {
                return false;
            }
        }
        return true;
    }
}