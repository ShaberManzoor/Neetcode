package ArraysAndHashing;
import java.util.HashSet;

class ContainsDuplicate_217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        boolean hasDup = false;
        for(int num: nums) {
            if(hs.contains(num)) {
                hasDup = true;
                break;
            }

            hs.add(num);
        }

        return hasDup;
    }
}