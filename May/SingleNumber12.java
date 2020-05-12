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

    /**
     * O(log N) approach
     * 
     * 
     *  public int singleNonDuplicate(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (nums[mid] == nums[mid ^ 1])
                lo = mid + 1;
            else
                hi = mid;
            }
        return nums[lo];
        }

        Note:
        odd xor 1 = odd-1
        even xor 1 = even+1
     */
}