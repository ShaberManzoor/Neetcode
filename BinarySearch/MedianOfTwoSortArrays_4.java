package BinarySearch;

public class MedianOfTwoSortArrays_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if(m>n) return findMedianSortedArrays(nums2, nums1);

        int left_part = (m + n + 1) / 2; //total no. of partitions which should be in left half of the merge array
        int l = 0, h = m;

        while(l<=h) {
            int i = (l+h)/2; //no. of elements to take from nums1
            int j = left_part - i; //no. of elements to take from nums2

            int aLeft = i > 0 ? nums1[i-1] : Integer.MIN_VALUE; //last element from left partition of nums1
            int aRight = i < m ? nums1[i] : Integer.MAX_VALUE; //first element from right partition of nums1
            int bLeft = j > 0 ? nums2[j-1] : Integer.MIN_VALUE; //last element from left partition of nums2
            int bRight = j < n ? nums2[j] : Integer.MAX_VALUE; //first element from right partition of nums2

            if(aLeft<=bRight && bLeft<=aRight) {
                if((m+n)%2==1) return Math.max(aLeft, bLeft);
                else return (double) (Math.max(aLeft, bLeft) + Math.min(aRight, bRight))/2;
            } else if(aLeft>bRight) {
                // we are taking the more element from first array we need few
                h = i - 1;
            } else {
                // we need more from the first array
                l = i + 1;
            }
        }

        return 0; //unreachable
    }
}
