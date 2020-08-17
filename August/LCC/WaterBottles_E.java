class Solution {
    public int numWaterBottles(int n, int e) {
        int ans = n;
        while(n >= e) {
            int temp = n;
            n /= e;
            ans += n;
            n += temp % e;
        }
        return ans;
    }
}
