public class twoCitySchedule3 {
  public int twoCitySchedCost(int[][] cs) {
        int n = cs.length >> 1;
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i-1][0] + cs[i - 1][0];
            dp[0][i] = dp[0][i - 1] + cs[i - 1][1];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + cs[i + j - 1][0], 
                                   dp[i][j - 1] + cs[i + j - 1][1]);
            }
        }
        return dp[n][n];
    }
    
    /** 
    public int twoCitySchedCost(int[][] costs) {
        int N = costs.length/2;
        int[] refund = new int[N * 2];
        int minCost = 0, index = 0;
        for(int[] cost : costs){
            refund[index++] = cost[1] - cost[0];
            minCost += cost[0];
        }
        Arrays.sort(refund);
        for(int i = 0; i < N; i++){
            minCost += refund[i];
        }
        return minCost;
    }
    **/
    
}
