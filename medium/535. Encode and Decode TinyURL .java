class Codec {
    List<String> urls = new ArrayList<String>();
    Map<Integer, String> map = new HashMap<>();
    int i=0;
    public String encode(String longUrl) {
        map.put(i,longUrl);
        return "http://tinyurl.com/"+i++;
    }
    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }
}


public class Codec {

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        return longUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortUrl;
    }
}
