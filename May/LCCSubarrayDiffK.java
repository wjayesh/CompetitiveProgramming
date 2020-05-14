package May;

import java.util.ArrayDeque;
import java.util.Deque;

public class LCCSubarrayDiffK {

    
public int[] maxSlidingWindow(int[] a, int k) {		
    if (a == null || k <= 0) {
        return new int[0];
    }
    int n = a.length;
    int[] r = new int[n-k+1];
    int ri = 0;
    // store index
    Deque<Integer> q = new ArrayDeque<>();
    for (int i = 0; i < a.length; i++) {
        // remove numbers out of range k
        while (!q.isEmpty() && q.peek() < i - k + 1) {
            q.poll();
        }
        // remove smaller numbers in k range as they are useless
        while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
            q.pollLast();
        }
        // q contains index... r contains content
        q.offer(i);
        if (i >= k - 1) {
            r[ri++] = a[q.peek()];
        }
    }
    return r;
}



    // public int longestSubarray(int[] nums, int limit) {
    //     if(nums.length == 0) {
    //         return 0;
    //     }
    //     int[] longest = new int[nums.length];
    //     longest[0] = 1;
    //     int max = nums[0], min = nums[0];
    //     for(int i = 1; i < nums.length; i++) {
    //         if(Math.abs(max - nums[i]) > limit || Math.abs(min - nums[i]) > limit) {
    //             longest[i] = longest[i - 1];
    //         } else {
    //             longest[i] = longest[i - 1] + 1;
    //             max = Math.max(max, nums[i]);
    //             min = Math.min(min, nums[i]);
    //         }
    //     }
    //     return longest[nums.length - 1];
    // }


}