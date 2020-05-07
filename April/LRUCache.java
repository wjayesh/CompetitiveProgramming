import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

class LRUCache {
    Map<Integer, Integer> cache; 
    Set<Integer> keySet;
    int capacity; 

    public LRUCache(int capacity) {
        this.cache = new LinkedHashMap<Integer, Integer>(capacity); 
        this.capacity = capacity; 
        keySet = cache.keySet();
    }
    
    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;
        int value = cache.remove(key);
        cache.put(key, value);
        return value;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key))
            cache.remove(key); 
  
        // If cache size is full, remove the least 
        // recently used. 
        else if (cache.size() == capacity) { 
            cache.remove(keySet.iterator().next());
        } 
  
        cache.put(key, value); 
        
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);      
    }
}