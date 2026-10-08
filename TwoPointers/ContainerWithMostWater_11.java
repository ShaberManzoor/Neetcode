package TwoPointers;

public class ContainerWithMostWater_11 {
    public int maxArea(int[] height) {
        int i = 0, j = height.length-1;
        int res = 0;
        while(i<j) {
            if(height[i]>height[j]) {
                int area = (j-i) * height[j--];
                res = Math.max(res, area);
            } else {
                int area = (j-i) * height[i++];
                res = Math.max(res, area);
            }
        }

        return res;
    }
}
