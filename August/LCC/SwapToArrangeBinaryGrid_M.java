
class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length, res=0;
        List<Integer> row = new LinkedList<>();
        for (int i=0; i<n; i++){
            int trailingZeroCnt=0;
            for (int j=n-1; j>-1 && grid[i][j]==0; j--) trailingZeroCnt++;
            row.add(trailingZeroCnt);
        }
        for (int curRowIdx=0, minTrailingZeros=n-1; curRowIdx<n; curRowIdx++, minTrailingZeros--){
            int satisfiedRowIdx =curRowIdx;
            while (satisfiedRowIdx <n && row.get(satisfiedRowIdx)<minTrailingZeros) satisfiedRowIdx++;
            if (satisfiedRowIdx ==n) return -1;
            int toRemove = row.remove(satisfiedRowIdx);
            row.add(curRowIdx, toRemove);
            res+=satisfiedRowIdx -curRowIdx;
        }
        return res;
    }
}

// bubble sort. the question wanted the triangle above the diagonal to have all zeroes. 
// so we count all trailing zeroes and sort them in a decreasing order.

// done greedily
