package SlidingWindow;

public class LongestRepeatingChar_424 {
    public int characterReplacement(String s, int k) {
        int freq[] = new int[26];
        int n = s.length();
        int maxFreq = 0, maxLen = 0, i = 0;

        for(int j=0;j<n;j++){
            maxFreq = Math.max(maxFreq, ++freq[s.charAt(j)-'A']);

            while(j-i+1 - maxFreq > k){
                freq[s.charAt(i)-'A']--;
                i++;
            }

            maxLen = Math.max(maxLen, j-i+1);
        }

        return maxLen;
    }
}
