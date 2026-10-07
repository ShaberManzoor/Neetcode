package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<n-2;i++) {
            if(nums[i]>0) break;
            if((i>0 && nums[i]==nums[i-1])) continue;

            int num1 = nums[i];

            int j = i+1, k = n-1;
            while(j<k) {
                int num2 = nums[j], num3 = nums[k];

                if(num3<0) break;

                int sum = num1 + num2 + num3;
                if(sum==0) {
                    res.add(new ArrayList<>(Arrays.asList(num1, num2, num3)));
                    j++;
                    k--;

                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }

                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if(sum>0) k--;
                else j++;
            }
        }

        return res;
    }
}
