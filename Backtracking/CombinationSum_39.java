package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39 {
    int n;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        n = candidates.length;
        backtrack(candidates, target, new ArrayList<>(), ans, 0);
        return ans;
    }
    void backtrack(int c[], int rem, List<Integer> temp, List<List<Integer>> ans, int st){
        if(rem<0) return;
        else if(rem==0) ans.add(new ArrayList<>(temp));
        else {
            for(int i=st;i<n;i++){
                temp.add(c[i]);
                backtrack(c, rem-c[i], temp, ans, i);
                temp.remove(temp.size()-1);
            }
        }
    }
}
