class PartitionKEqualSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }
        if(sum % k != 0) {
            return false;
        } else {
            reqSum = sum/k;
        }
        recurse(0, 0, k, nums);
        return indicator;
    }
    private int reqSum;
    private boolean indicator;
    
    private void recurse(int mask, int currsum, int k, int[] nums)  {
        if(k == -1) {
           indicator = true;
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if((mask & (1 << i)) == 0) {
                int newMask = mask | 1 << i;
                int newSum = currsum + nums[nums.length-1-i];
                if(newSum == reqSum) {
                    int a = k-1;
                    recurse(newMask, 0, a, nums);
                } else if(newSum < reqSum) {
                    recurse(newMask, newSum, k, nums);
                }
            }
        }
    }
}
