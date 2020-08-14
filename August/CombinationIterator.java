
class CombinationIterator {

    Queue<String> queue;

    public CombinationIterator(String characters, int combinationLength) {
        queue = new LinkedList();
        combinations(characters, 0, "", combinationLength);
    }

    public void combinations(String characters, int start, String soFar, int k) {
        if (k == 0) {
            queue.add(soFar);
            return;
        }
        
        for(int i = start; i < characters.length(); i++) {
            combinations(characters, i + 1, soFar + characters.charAt(i), k - 1);
        }
    }
    
    public String next() {
        return queue.poll();
    }
    
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

// recursion; add chars until combinationlength reached; then add in queue. 
