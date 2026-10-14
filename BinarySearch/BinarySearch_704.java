package BinarySearch;

public class BinarySearch_704 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, h = n-1;

        int ind = -1;
        while(l<=h) {
            int m = (h-l) + l/2;
            if(nums[m]==target) {
                ind = m;
                break;
            } else if(nums[m]>target) {
                h = m-1;
            } else {
                l = m+1;
            }
        }

        return ind;
    }
}
