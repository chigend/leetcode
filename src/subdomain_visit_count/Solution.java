package subdomain_visit_count;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] domains = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> result  = solution.subdomainVisits(domains);
        System.out.println(result);
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String cpDomain : cpdomains) {
            int index = cpDomain.indexOf(' ');
            String domain = cpDomain.substring(index + 1);
            Integer count = Integer.valueOf(cpDomain.substring(0, index));
            int start = -1;
            do{
                String subDomain = domain.substring(start + 1);
                map.put(subDomain, map.getOrDefault(subDomain, 0) + count);
            }while ((start = domain.indexOf('.', start + 1)) > -1);
        }
        for (Map.Entry<String, Integer> entry :  map.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }
        return result;
    }
}
