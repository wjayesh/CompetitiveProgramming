package May;

public class LCCSubarrayDiffK {
    public int longestSubarray(int[] nums, int limit) {
        if(nums.length == 0) {
            return 0;
        }
        int[] longest = new int[nums.length];
        longest[0] = 1;
        int max = nums[0], min = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(Math.abs(max - nums[i]) > limit || Math.abs(min - nums[i]) > limit) {
                longest[i] = longest[i - 1];
            } else {
                longest[i] = longest[i - 1] + 1;
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i]);
            }
        }
        return longest[nums.length - 1];
    }
}