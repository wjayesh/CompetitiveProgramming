package May;

import java.util.*;

public class LCCDestCity {
    public String destCity(List<List<String>> paths) {
        HashMap<String, String> map = new HashMap<>();
        for(List<String> pair : paths) {
            map.put(pair.get(0), pair.get(1));
        }
        return getDest(map, paths.get(0).get(0));
    }

    private String getDest(HashMap<String, String> map, String string) {
        if(!map.containsKey(string)) {
            return string;
        } else {
            return getDest(map, map.get(string));
        }
    }
    
}