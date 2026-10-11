package SlidingWindow;

public class MinWinSubstring_76 {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if(n>m) return "";

        int freq[] = new int[128];
        for(char c: t.toCharArray()) {
            freq[c]++;
        }

        int minLen = Integer.MAX_VALUE;
        int st = 0, left = 0;
        int missing = t.length();

        for(int right=0;right<s.length();right++) {
            char c = s.charAt(right);

            if(freq[c]>0) missing--;
            freq[c]--;

            while(missing==0) {
                int winLen = right-left+1;

                if(minLen>winLen) {
                    st = left;
                    minLen = winLen;
                }

                //removing the left most
                char leftChar = s.charAt(left);
                freq[leftChar]++;

                if(freq[leftChar]>0) missing++;

                left++;
            }
        }

        if(minLen==Integer.MAX_VALUE) return "";

        return s.substring(st, st+minLen);
    }
}
