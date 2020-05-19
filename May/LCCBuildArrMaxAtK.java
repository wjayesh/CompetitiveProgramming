package May;

public class LCCBuildArrMaxAtK {
    long[][][] memo;
    long mod = (long)1e9 + 7;
    int N, M;
    long rec(int i, int msf, int kleft) {
        if (i == N) {
            return kleft == 0 ? 1 : 0;
        }        
        if (kleft < 0) return 0;
        if (memo[i][msf][kleft] != -1)  return memo[i][msf][kleft];
        
        long ans = 0;
        for (int j = 1; j <= M; j++) {
            ans = (ans + rec(i+1, Math.max(msf, j), j > msf ? kleft-1 : kleft)) % mod;
        }
                   
        return memo[i][msf][kleft] = ans;
    }
    
    
    public int numOfArrays(int n, int m, int K) {
        memo = new long[n+1][m+1][K+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= K; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }
        this.N = n;
        M = m;
        long ans = 0;
        for (int i = 1; i <= m; i++) {
            ans = (ans + rec(1, i, K-1)) % mod;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        LCCBuildArrMaxAtK obj =  new LCCBuildArrMaxAtK();
        System.out.println(obj.numOfArrays(2, 3, 1));
    }
}