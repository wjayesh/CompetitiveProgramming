public class UniquePaths29 {
    public int uniquePaths(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur, 1); 
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j - 1];
            }
        }
        return curr[n - 1];
    }
}


// https://leetcode.com/problems/unique-paths/discuss/22954/C%2B%2B-DP
// dp approach but optimised space 
