package May;

import java.util.HashMap;

public class TownJudge10 {
    public int findJudge(int N, int[][] trust) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < trust.length; i++) {
            map.put(trust[i][0], map.getOrDefault(trust[i][0], 0) - 1);
            map.put(trust[i][1], map.getOrDefault(trust[i][1], 0) + 1);
        }
        for(int i = 0; i < trust.length; i++) {
            if(map.get(trust[i][1]) == N - 1) {
                return trust[i][1];
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        TownJudge10 obj = new TownJudge10();
        System.out.println(obj.findJudge(3, new int[][]{{1,3},{2,3},{3,1}}));
    }
    
}