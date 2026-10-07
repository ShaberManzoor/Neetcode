package TwoPointers;

public class ValidPalindrome_125 {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;

        boolean isPalin = true;
        while(i<j) {
            char a = Character.toLowerCase(s.charAt(i)), b = Character.toLowerCase(s.charAt(j));

            if(!Character.isLetterOrDigit(a)) {
                i++;
                continue;
            }
            else if(!Character.isLetterOrDigit(b)){
                j--;
                continue;
            } 

            if(a!=b) {
                isPalin = false;
                break;
            }

            i++;
            j--;
        }

        return isPalin;
    }
}
