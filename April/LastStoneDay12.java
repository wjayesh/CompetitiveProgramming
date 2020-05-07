import java.util.Collections;
import java.util.PriorityQueue;

class LastStoneDay12 {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i =0; i < stones.length; i++) {
            pq.add(stones[i]);
        }
        while(pq.size() >= 2) {
            int t1 = pq.poll();
            int t2 = pq.poll();
            if (t1 != t2) {
                pq.add(Math.abs(t1-t2));
            }
        }
        if (pq.isEmpty()) {
            return 0;
        } else {
            return pq.poll();
        }
    }
    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2,2}));
    }
}