package May;

import java.util.ArrayDeque;
import java.util.Deque;

public class ConstrainedSubArray {
    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int max = nums[0], sum = 0;
        for(int num: nums) {
            dq.offer(num);
            sum += num;
            max = Math.max(sum, max);
            if(dq.size() > k) {
                sum -= dq.pollFirst();
            }
        }
        return max;
    }
}