class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        HashMap<Integer, Integer> maxAfter =  new HashMap<>();
        int maxV = events[events.length-1][2];
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = events.length - 1; i >= 0; i--) {
            maxV = Math.max(maxV, events[i][2]);
            maxAfter.put(events[i][0], maxV);
            set.add(events[i][0]);
        }
        
        int res = maxV, start = -1;
        for(int i = 0; i < events.length; i++) {
            try {
                start = set.higher(events[i][1]);    
            } catch (NullPointerException e) {
                continue;
            }
            res = Math.max(res, maxAfter.get(start) + events[i][2]);
        }
        return res;
    }
}