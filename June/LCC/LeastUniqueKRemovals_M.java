class LeastUniqueKRemovals_M {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Integer> l = new ArrayList<>(map.keySet());
        Collections.sort(l, (a, b) -> map.get(a) - map.get(b));
        int n = map.size(), remove = 0, idx = 0;
        while (k > 0 && idx < n) {
            k -= map.get(l.get(idx++));
            if (k >= 0) {
                remove++;
            }
        }
        return n - remove;
    }
}

