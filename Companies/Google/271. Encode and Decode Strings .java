public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        for (String s : strs) {
            sb.append(s.length()).append("%").append(s).append("%");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        int start = 0;
        while (start < s.length() && s.indexOf("%", start) != -1) {
            i = s.indexOf("%", start);
            int len = Integer.parseInt(s.substring(start, i));
            i++;
            String s1 = s.substring(i, i + len);
            res.add(s1);
            start = i + len + 1;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));