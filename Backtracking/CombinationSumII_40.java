package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);

        return res;
    }

    private void backtrack(int[] nums, int remaining, int start,
                           List<Integer> temp, List<List<Integer>> res) {

        if (remaining == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < nums.length; i++) {

            // Skip duplicates at the same recursion level
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // Pruning: remaining candidates are too large
            if (nums[i] > remaining) {
                break;
            }

            temp.add(nums[i]);

            backtrack(nums, remaining - nums[i], i + 1, temp, res);

            temp.remove(temp.size() - 1);
        }
    }
}
