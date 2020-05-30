public class LCCPositiveStepByStepSum{
  int min = 0;
    public int minStartValue(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum < min) {
                min = sum;
            }
        }
        return Math.abs(min) + 1;
    }
}
