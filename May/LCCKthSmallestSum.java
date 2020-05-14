package May;

import java.util.PriorityQueue;

public class LCCKthSmallestSum {
    public int kthSmallest(int[][] mat, int k) {
        final int R = mat.length;
        final int C = mat[0].length;
    
        // max priority queue for the first row
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int c = 0; c < C; c++) {
            pq.add(mat[0][c]);
            // keep pq size less than or equal to k
            if (pq.size() > k) {
                pq.poll();
            }
        }
    
        for (int r = 1; r < R; r++) {
            // max priority queue for the i-th row
            PriorityQueue<Integer> nextPq = new PriorityQueue<>((a, b) -> b - a);
            for (int i : pq) {
                for (int c = 0; c < C; c++) {
                    nextPq.add(i + mat[r][c]);
                    // keep pq size less than or equal to k
                    if (nextPq.size() > k) {
                        nextPq.poll();
                    }
                }
            }
    
            pq = nextPq;
        }
    
        return pq.poll();
    }
    
}