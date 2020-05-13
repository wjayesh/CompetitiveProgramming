package May;

public class LCCOnesKAway {
    public boolean kLengthApart(int[] nums, int k) {
        int i = 0, count = 0;
        while(nums[i] != 1) {
            i++;
        }
        for(int j = i + 1; j < nums.length; j++) {
            if(nums[j] == 0) {
                count++;
            } else {
                if(count < k) {
                    return false;
                }
                count = 0;
            }
        }
        return true;
    }
}