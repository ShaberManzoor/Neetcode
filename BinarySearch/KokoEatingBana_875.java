package BinarySearch;

public class KokoEatingBana_875 {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = Integer.MIN_VALUE;
        for(int pile: piles) {
            high = Math.max(pile, high);
        }

        int k = Integer.MAX_VALUE;
        while(low<=high) {
            int mid = (high-low)/2 + low;

            if(possible(piles, h, mid)) {
                k = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return k;
    }

    public boolean possible(int[] piles, int h, int k) {
        int time = 0;

        for(int pile: piles) {
            time += (pile + k - 1) / k;

            if(time>h) break;
        }

        return time<=h ? true : false;
    }
}
