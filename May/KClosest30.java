package May; 

import java.util.PriorityQueue;

public class KClosest30 {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>();
        for(int i = 0; i < points.length; i++) {
            double dist = computeDist(points[i]);
            pq.offer(dist);
        }
        int result[][] = new int[points.length][];
        int i = 0;
        while(!pq.isEmpty() && i < K) {
            result[i][0] = points[i][0];
            result[i][1] = points[i][1];
            i++;
        }
        return result;
    }

    public double computeDist(int[] point) {
        return Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }
}