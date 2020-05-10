package April;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AnagramsDay6 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            String word = strs[i]; 
            char[] letters = word.toCharArray(); 
            Arrays.sort(letters); 
            String newWord = new String(letters); 
            if (map.containsKey(newWord)) { 
                map.get(newWord).add(word); 
            } 
            else {
                List<String> words = new ArrayList<>(); 
                words.add(word); 
                map.put(newWord, words); 
            } 
        }
        return new ArrayList<>(map.values());
    }


}