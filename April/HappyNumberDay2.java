import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isHappy(int n) {
        int number = n;
        while (number != 1) {
           List<Integer> digits = new ArrayList<Integer>();
            digits = populateDigits(number);
            number = 0;
            for (int i = 0; i < digits.size(); i++) {
                number += Math.pow(digits.get(i), 2);
            } 
        }
        return true;
    }
    
    List<Integer> populateDigits(int n) {
        List<Integer> digits = new ArrayList<Integer>();
        while (n != 0) {
            digits.add(n % 10);
            n /= 10;
        }
        return digits;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.isHappy(2)); 
    }
}