package ArraysAndHashing;

import java.util.HashSet;

public class LongConsSeq_128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();

        for(int num: nums) {
            hs.add(num);
        }

        int longest = 0;
        for(int num: hs) {
            if(hs.contains(num-1)) continue;

            int cnt = 1;
            int curr = num;
            while(hs.contains(curr + 1)) {
                cnt++;
                curr++;
            }

            longest = Math.max(cnt, longest);
        }

        return longest;
    }
}
