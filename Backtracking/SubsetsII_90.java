package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        solve(nums, 0, new ArrayList<>(), res);

        return res;
    }

    public void solve(int[] nums, int start, List<Integer> temp, List<List<Integer>> res) {
        res.add(new ArrayList<>(temp));

        for(int i=start;i<nums.length;i++) {
            if(i>start && nums[i]==nums[i-1]) continue;

            temp.add(nums[i]);
            solve(nums, i+1, temp, res);
            temp.remove(temp.size()-1);
        }
    }
}
