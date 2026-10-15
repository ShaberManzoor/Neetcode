package BinarySearch;

public class RotatedSubArrayMin_153 {
    public int findMin(int[] nums) {
        int l = 0, h = nums.length-1;

        int min = Integer.MAX_VALUE;
        while(l<=h) {
            int mid = (h+l)/2;

            min = Math.min(nums[mid], min);

            if(nums[mid]>nums[h]) l = mid+1;
            else h = mid-1;
        }

        return min;
    }
}
