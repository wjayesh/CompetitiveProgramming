package May;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class LCContestApple {
    HashMap<Integer, Boolean> map = new HashMap<>();
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        int sum = edges.length * 2;
        for(int i = 0; i < n; i++) {
            if(noAppleBelow(i, edges, hasApple)) {
                sum -= 2;
            }
        }
        return sum;
    }
    
    private boolean noAppleBelow(int n, int[][] edges, List<Boolean> hasApple) {
        if(map.containsKey(n)) {
            return map.get(n);
        }
        if(!hasApple.get(n)) {
            for(int i = 0; i < edges.length; i++) {
                if(edges[i][0] == n) {
                    if(!noAppleBelow(edges[i][1], edges, hasApple)) {
                        return false;    
                    }
                } 
            }
        } else {
            map.put(n, false);
            return false;
        }
        map.put(n, true);
        return true;
    }
    public static void main(String[] args) {
        LCContestApple obj = new LCContestApple();
        ArrayList<Boolean> list = new ArrayList<Boolean>();
        list.add(false); list.add(true);
        obj.minTime(2, new int[][]{{1, 2}}, list);
    }
}
    
