package May;

import java.util.LinkedList;
import java.util.List;

public class LCContestBuildArray {
    public List<String> buildArray(int[] target, int n) {
        int i = 0, j = 1;
        List<String> ans = new LinkedList<String>();
        while(j <= n && i < target.length) {
            if(target[i] == j) {
                ans.add("Push");
                i++; j++;
            } else {
                ans.add("Push");
                ans.add("Pop");
                j++;
            }
        }
        return ans;
    }
    
}