//

class HashSet2 {
    private int m;
    private LinkedList<Integer>[] arr;

    /** Initialize your data structure here. */
    public MyHashSet() {
        m = 3331;
        arr = new LinkedList[m];
    }
    
    public void add(int key) {
       if(!contains(key)){
        int loc = key % m;
        if(arr[loc] == null) {
            arr[loc] = new LinkedList<Integer>();
        }
        arr[loc].addFirst(key);
       }
    }
    
    public void remove(int key) {
        int loc = key % m;
        if(arr[loc]!=null) {
            arr[loc].removeFirstOccurrence(key);
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int loc = key % m;
        if(arr[loc] != null) {
            return arr[loc].contains(key);
        }
        return false;
    }
}
