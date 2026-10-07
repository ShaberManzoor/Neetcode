package TwoPointers;

public class TwoSum2_167 {
    public int[] twoSum(int[] numbers, int target) {
        int idx1 = 0, idx2 = numbers.length-1;

        while(idx1<idx2) {
            if(numbers[idx1]+numbers[idx2]==target) break;

            if(numbers[idx1]+numbers[idx2]<target) idx1++;
            else idx2--;
        }

        return new int[]{idx1+1, idx2+1};
    }
}
