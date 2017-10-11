package encode_and_decode_tinyurl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Codec2 {
    private String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private Map<String, String> shortToLong = new HashMap<>();
    private Map<String, String> longToShort = new HashMap<>();
    public String encode(String longUrl) {
        if (longToShort.containsKey(longUrl)) {
            return longToShort.get(longUrl);
        }
        StringBuilder sb = null;
        do {
            sb = new StringBuilder();
            Random r = new Random();
            for (int i = 0; i < 6; i++) {
                sb.append(charSet.charAt(r.nextInt(charSet.length())));
            }
        }while (shortToLong.containsKey(sb.toString()));
        String key = sb.toString();
        shortToLong.put(key, longUrl);
        longToShort.put(longUrl, key);
        return key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortToLong.get(shortUrl);
    }
}
