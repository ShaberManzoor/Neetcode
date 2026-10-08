package TwoPointers;

public class TrappingRainWater_42 {
    public int trap(int[] height) {
        int n = height.length;
        int[] ng = new int[n], pg = new int[n];

        pg[0] = height[0];
        for(int i=1;i<n;i++) {
            pg[i] = Math.max(pg[i-1], height[i]);
        }

        ng[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--) {
            ng[i] = Math.max(ng[i+1], height[i]);
        }

        int res = 0;
        for(int i=1;i<n-1;i++) {
            if(ng[i]<=height[i] || pg[i]<=height[i]) continue;

            res += Math.min(ng[i], pg[i]) - height[i];
        }

        return res;
    }

        public int trapOptimised(int[] height) {
        int n = height.length;
        int i = 0, j = n-1, lmax = height[0], rmax = height[n-1];
        int res = 0;

        while(i<j) {
            if(height[i]<=height[j]) {
                if(lmax<=height[i]) {
                    lmax = height[i];
                } else {
                    res += lmax - height[i];
                }
                i++;
            } else {
                if(rmax<=height[j]) {
                    rmax = height[j];
                } else {
                    res += rmax - height[j];
                }
                j--;
            }
        }

        return res;
    }
}
