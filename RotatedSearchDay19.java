
public class RotatedSearchDay19 {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
        
        
    }

    private int binarySearch(int[] nums, int target, int lo, int hi) {
        int mid = (lo + hi)/2;
        if(nums[mid] > nums[mid+1]) {
            if(target > nums[hi]){
                return binarySearch(nums, target, lo, mid);
            } else if(target < nums[hi]){
                return binarySearch(nums, target, mid + 1, hi);
            } else if(target == nums[mid]){
                return mid;
            }
        } else {

        }
        return 0;
    }

}