package BinarySearch;

public class RotateArraySearch_33 {
    public int search(int[] nums, int target) {
        int l = 0, h = nums.length-1;

        while(l<=h) {
            int mid = (h-l)/2 + l;

            if(nums[mid]==target) return mid;

            // right half sorted
            if(nums[mid]<nums[h]) {
                if(nums[mid]<target && target<=nums[h]) l = mid+1;
                else h = mid-1;
            } else {
                //left half sorted
                if(nums[mid]>target && target>=nums[l]) h = mid-1;
                else l = mid+1;
            }
        }

        return -1;
    }
}
