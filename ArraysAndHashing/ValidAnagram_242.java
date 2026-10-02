package ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;

class ValidAnagram_242 {
    public boolean isAnagram(String s, String t) {
        int m = s.length(), n = t.length();
        if(m!=n) return false;

        Map<Character, Integer> freq = new HashMap<>();
        for(char c: s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        boolean isAnagram = true;
        for(char c: t.toCharArray()) {
            if(freq.get(c)!=null && freq.get(c)!=0) {
                freq.put(c, freq.get(c)-1);
                if(freq.get(c)==0) freq.remove(c);
            }else {
                isAnagram = false;
                break;
            }
        }

        return isAnagram;
    }
}