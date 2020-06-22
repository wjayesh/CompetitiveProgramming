import java.util.*;

class AvoidFlood_M {
    public int[] avoidFlood(int[] rains) {
        HashMap<Integer, Integer> mapLakes = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int res[] = new int[rains.length];
        for(int i = 0; i < rains.length; i++) {
            res[i] = -1;
        }
        for(int i = 0; i < rains.length; i++) {
            if(rains[i] == 0) {
                q.add(i);
                continue;
            }
            if(mapLakes.containsKey(rains[i])) {
                if(q.size() == 0) {
                    return new int[0];
                }
                int idx = q.poll();
                if(idx < mapLakes.get(rains[i])) {
                    return new int[0];
                }
                res[idx] = rains[i];
                mapLakes.put(rains[i], i);
            } else {
                mapLakes.put(rains[i], i);
            }
        }
        while(q.size() > 0) {
            res[q.poll()] = 1;
        }
        return res;
    }
}
