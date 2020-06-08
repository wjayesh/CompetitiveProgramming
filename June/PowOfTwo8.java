public class PowOfTwo8 {
  public boolean isPowerOfTwo(int n) {
        if(n <= 0) {
            return false;
        }
        boolean flag = false;
        for(int i = 0; i < 32; i++) {
            if(((1 << i) & n) == n) {
                flag = true;
            }
        }
        return flag;
    }
}
