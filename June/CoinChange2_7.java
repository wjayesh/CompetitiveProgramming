public class CoinChange2_7 {
  public int change(int amount, int[] coins) {
        int [] combi = new int[amount+1];
        combi[0] = 1;
        for(int i = 0; i < coins.length; i++){
            for(int j=1; j< amount+1; j++){
                if(j-coins[i]>=0)
                    combi[j] = combi[j]+combi[j-coins[i]];
            }
        }
        for(int a: combi)
            System.out.print(a+" ");
        return combi[amount];
    }
}
