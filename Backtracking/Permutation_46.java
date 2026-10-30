package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        solve(nums, new ArrayList<>(), res);
        return res;
    }

    public void solve(int[] nums, List<Integer> temp, List<List<Integer>> res) {
        if(temp.size()==nums.length) {
            res.add(new ArrayList<>(temp));
        } else {
            for(int i=0;i<nums.length;i++) {
                if(temp.contains(nums[i])) continue;

                temp.add(nums[i]);
                solve(nums, temp, res);
                temp.remove(temp.size()-1);
            }
        }
    }
}
