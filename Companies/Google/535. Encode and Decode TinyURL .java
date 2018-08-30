public class Codec {

    HashMap<String, String> encodeMap;
    HashMap<String, String> decodeMap;
    private static final String BASE = "www.base.com/";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        encodeMap = new HashMap<>();
        decodeMap = new HashMap<>();
        if (encodeMap.containsKey(longUrl)) {
            return encodeMap.get(longUrl);
        }
        String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String code = "";
        do {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 6; i++) {
                int index = (int)Math.random() * charSet.length();
                sb.append(charSet.charAt(index));
            }
            code = sb.toString();
        } while (encodeMap.containsKey(code));
        code = BASE + code;
        encodeMap.put(longUrl, code);
        decodeMap.put(code, longUrl);
        return code;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return decodeMap.get(shortUrl).replace(BASE, "");
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));