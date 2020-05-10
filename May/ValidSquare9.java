package May;

public class ValidSquare9 {
    public boolean isPerfectSquare(int num) {
        if (num < 0) return false;
            if (num == 0) return true;

            long left = 1;
            long right = (long)Integer.MAX_VALUE;

            while (left <= right)
            {
                long mid = (left + right) / 2;
                long midSqr = mid * mid;
                if (midSqr == num) return true;
                else if (midSqr > num) right = mid - 1;
                else left = mid + 1;
            }

            return false;
        
    }
    
}