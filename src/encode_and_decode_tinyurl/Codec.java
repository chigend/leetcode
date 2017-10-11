package encode_and_decode_tinyurl;

import java.util.HashMap;
import java.util.Map;

public class Codec {

    private Map<String, String> map = new HashMap<>();
    private int size = 0;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = ++size + "";
        map.put(key, longUrl);
        return key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}