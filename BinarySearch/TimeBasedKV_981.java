package BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKV_981 {
    record Pair(String val, int ts) {}

    Map<String, List<Pair>> hm;
    public TimeBasedKV_981() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!hm.containsKey(key)) {
            hm.put(key, new ArrayList<Pair>());
        }

        hm.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Pair> val = hm.get(key);

        if(val==null) return "";
        
        String res = "";
        int l = 0, h = val.size()-1;

        while(l<=h) {
            int m = (h-l)/2 + l;
            int ts = val.get(m).ts();

            if(ts==timestamp) {
                res = val.get(m).val();
                break;
            } else if(ts<timestamp) {
                res = val.get(m).val();
                l = m+1;
            } else {
                h = m-1;
            }
        }

        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */