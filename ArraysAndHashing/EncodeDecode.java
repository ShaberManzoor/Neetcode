package ArraysAndHashing;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {

    private int[] ind;
    public String encode(List<String> strs) {
        int n = strs.size();
        ind = new int[n+1];

        StringBuilder encodedStr = new StringBuilder();
        for(int i=0;i<n;i++) {
            encodedStr.append(strs.get(i));
            ind[i+1] = ind[i] + strs.get(i).length();
        }

        return encodedStr.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        for(int i=1;i<ind.length;i++) {
            res.add(str.substring(ind[i-1], ind[i]));
        }

        return res;
    }
}
