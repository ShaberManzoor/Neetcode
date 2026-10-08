package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring_3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> hs = new HashSet<>();
        int max = 0, i = 0;

        for(int j=0;j<s.length();j++) {
            char ch = s.charAt(j);

            while(hs.contains(ch)) {
                hs.remove(s.charAt(i++));
            }

            hs.add(ch);
            max = Math.max(max, j-i+1);
        }

        return max;
    }
}
