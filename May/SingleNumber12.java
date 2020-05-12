package May;

import java.util.HashSet;

public class SingleNumber12 {
    public int singleNonDuplicate(int[] nums) {
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) {
            if(set.contains(num)) {
                sum -= num;
            } else {
                sum += num;
                set.add(num);
            }
        }
        return sum;
    }
}