package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition_131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res);
        return res;
    }

    public void backtrack(String s, int start, List<String> temp, List<List<String>> res) {
        if(start==s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int end=start;end<s.length();end++) {
            String sub = s.substring(start, end+1);

            if(!isPalin(sub)) {
                continue;
            }

            temp.add(sub);
            backtrack(s, end+1, temp, res);
            temp.remove(temp.size()-1);
        }
    }

    public boolean isPalin(String s) {
        int l = 0, h = s.length()-1;
        while(l<h) {
            if(s.charAt(l++)!=s.charAt(h--)) return false;
        }

        return true;
    }
}
