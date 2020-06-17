public class MakeMBouquets_M {
  public int minDays(int[] A, int m, int k) {
        int n = A.length, left = 1, right = (int)1e9;
        if (m * k > n) return -1;
        while (left < right) {
            int mid = (left + right) / 2, flow = 0, bouq = 0;
            for (int j = 0; j < n; ++j) {
                if (A[j] > mid) {
                    flow = 0;
                } else if (++flow >= k) {
                    bouq++;
                    flow = 0;
                }
            }
            if (bouq < m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

/** 
This is a typical binary search on solution set (nvm, I just call it that).
We know that more flowers would bloom and more bouquets can be made as days move on.
Think about this:
On day 1, i1 flowers open and we can make k1 bouquets.
On day 2, i2 fowers open and we can make k2 bouquets where i2>=i1, k2>=k1
...
On the last day, all flowers open and we can make kn bouquets.

See, they were actully in a nondecreasing order. Then you could simply apply binary search on it, that is: find a mid day → validate if we can make k bouquests on that exact date → move to left or right part based on the validation → you are good to go
**/
