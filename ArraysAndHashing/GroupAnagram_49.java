package ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<>();

        for(String str: strs) {
            char c[] = str.toCharArray();
            Arrays.sort(c);
            String sw = new String(c);

            if(!hm.containsKey(sw)) {
                hm.put(sw, new ArrayList<>());
            }

            hm.get(sw).add(str);
        }

        return new ArrayList<>(hm.values());
    }
}
