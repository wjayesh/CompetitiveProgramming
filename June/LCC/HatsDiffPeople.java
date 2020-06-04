public class HatsDiffPeople {
  public int numberWays(List<List<Integer>> hats) {
        int n = hats.size();
        List<Integer>[] h2p = new List[41]; // h2p[i] indicates the list of people who can wear i_th hat
        for (int i = 1; i <= 40; i++) h2p[i] = new ArrayList<>();
        for (int i = 0; i < n; i++)
            for (int hat : hats.get(i))
                h2p[hat].add(i);
        Integer[][] dp = new Integer[41][1024];
        return dfs(h2p, (1 << n) - 1, 1, 0, dp);
    }
    // dfs(...hat, assignedPeople...) number of ways to assign up to `hat` different hats to n people keep in mind that `assignedPeople` is
    //     the mask of list of people were assigned hat
    int dfs(List<Integer>[] h2p, int allMask, int hat, int assignedPeople, Integer[][] dp) {
        if (assignedPeople == allMask) return 1; // Check if assigned different hats to all people
        if (hat > 40) return 0; // no more hats to process
        if (dp[hat][assignedPeople] != null) return dp[hat][assignedPeople];
        int ans = dfs(h2p, allMask, hat + 1, assignedPeople, dp); // Don't wear this hat
        for (int p : h2p[hat]) {
            if (((assignedPeople >> p) & 1) == 1) continue; // Skip if person `p` was assigned hat
            ans += dfs(h2p, allMask, hat + 1, assignedPeople | (1 << p), dp); // Wear this hat for p_th person
            ans %= 1_000_000_007;
        }
        return dp[hat][assignedPeople] = ans;
    }
}
