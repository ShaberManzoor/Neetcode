package ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>(); // {val, ind}
        
        hm.put(nums[0], 0);
        int i = -1, j = -1;
        for(int k=1;k<nums.length;k++) {
            if(hm.containsKey(target-nums[k])) {
                i = hm.get(target-nums[k]);
                j = k;

                break;
            }

            hm.put(nums[k], k);
        }

        return new int[]{i, j};
    }
}
