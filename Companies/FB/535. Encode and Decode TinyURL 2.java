public class Codec {

    Map<String, String> encode = new HashMap<>();
    Map<String, String> decode = new HashMap<>();
    private static final String codes = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final String base = "www.qiji.com/";
    private static final int count = 6;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (encode.containsKey(longUrl)) {
            return encode.get(longUrl);
        }
        StringBuffer sb = new StringBuffer();
        String res = "";
        do {
            for (int i = 0; i < count; i++) {
                sb.append(codes.charAt(new Random().nextInt(codes.length())));
            }
            res = sb.toString();
        } while (encode.containsKey(res));
        String url = base + res;
        encode.put(longUrl, url);
        decode.put(url, longUrl);
        return url;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String longUrl = decode.get(shortUrl);
        return longUrl;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));