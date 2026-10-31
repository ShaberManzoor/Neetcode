package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParantheses_22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(n, 0, 0, "", res);
        return res;
    }

    public void generate(int n, int open, int close, String curr, List<String> res) {
        if(curr.length()==n*2) {
            res.add(curr);
            return;
        }

        if(open<n) generate(n, open+1, close, curr + "(", res);
        if(close<open) generate(n, open, close+1, curr + ")", res);
    }
}
