
class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        int res = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (map.containsKey(sum - target)) {
                res = Math.max(res, map.get(sum - target) + 1);
            }
            map.put(sum, res);
        }

        return res;
    }
}


// how to identify that prefix sum should be used?
/**
* Identified this because

1) We are looking for subarrays
2) Sliding window won't work because there are negative numbers
3) Prefix Sum problems always involve a target

**/
