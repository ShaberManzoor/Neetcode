package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Susbsets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        solve(nums, 0, new ArrayList<>(), res);
        return res;
    }

    public void solve(int[] nums, int st, List<Integer> temp, List<List<Integer>> res) {
        res.add(new ArrayList<>(temp));

        for(int i=st;i<nums.length;i++) {
            temp.add(nums[i]);
            solve(nums, i+1, temp, res);
            temp.remove(temp.size()-1);
        }
    }
}
